/* 
 * SMAPSourceDebugExtension.java - Parse source debug extensions and
 * enhance stack traces.
 * 
 * Copyright (c) 2012 Michael Schierl
 * 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *   
 * - Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *   
 * - Neither name of the copyright holders nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *   
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND THE CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDERS OR THE CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS
 * OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package smap;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 * Utility class to parse Source Debug Extensions and enhance stack traces.
 * 
 * Note that only the first stratum is parsed and used.
 * 
 * @author Michael Schierl
 */
public class SMAPSourceDebugExtension {

    /**
     * Enhance a stack trace with information from source debug extensions.
     * 
     * @param t
     *            Throwable whose stack trace should be enhanced
     * @param cl
     *            Class loader to load source debug extensions from
     * @param keepOriginalFrames
     *            Whether to keep the original frames referring to Java source
     *            or drop them
     * @param packageNames
     *            Names of packages that should be scanned for source debug
     *            extensions, or empty to scan all packages
     * @throws IOException
     *             if an I/O error occurs
     */
    public static void enhanceStackTrace(Throwable t, ClassLoader cl, boolean keepOriginalFrames, String... packageNames) throws IOException {
        enhanceStackTrace(t, new HashMap<String, SMAPSourceDebugExtension>(), cl, keepOriginalFrames, packageNames);
    }

    /**
     * Enhance a stack trace with information from source debug extensions.
     * Provide a custom cache of already resolved and parsed source debug
     * extensions, to avoid parsing them for every new exception.
     * 
     * @param t
     *            Throwable whose stack trace should be enhanced
     * @param cache
     *            Cache to be used and filled
     * @param cl
     *            Class loader to load source debug extensions from
     * @param keepOriginalFrames
     *            Whether to keep the original frames referring to Java source
     *            or drop them
     * @param packageNames
     *            Names of packages that should be scanned for source debug
     *            extensions, or empty to scan all packages
     * @throws IOException
     *             if an I/O error occurs
     */
    public static void enhanceStackTrace(Throwable t, Map<String, SMAPSourceDebugExtension> cache, ClassLoader cl, boolean keepOriginalFrames, String... packageNames) throws IOException {
        StackTraceElement[] elements = t.getStackTrace();
        List<StackTraceElement> newElements = null;
        for (int i = 0; i < elements.length; i++) {
            String className = elements[i].getClassName();
            SMAPSourceDebugExtension smap = cache.get(className);
            if (smap == null) {
                boolean found = false;
                for (String packageName : packageNames) {
                    if (className.startsWith(packageName + ".")) {
                        found = true;
                        break;
                    }
                }
                if (found || packageNames.length == 0) {
                    InputStream in = cl.getResourceAsStream(className.replace('.', '/') + ".class");
                    if (in != null) {
                        String value = extractSourceDebugExtension(in);
                        in.close();
                        if (value != null) {
                            value = value.replaceAll("\r\n?", "\n");
                            if (value.startsWith("SMAP\n")) {
                                smap = new SMAPSourceDebugExtension(value);
                                cache.put(className, smap);
                            }
                        }
                    }
                }
            }
            StackTraceElement newFrame = null;
            if (smap != null) {
                int[] inputLineInfo = smap.reverseLineMapping.get(elements[i].getLineNumber());
                if (inputLineInfo != null && elements[i].getFileName().equals(smap.generatedFileName)) {
                    FileInfo inputFileInfo = smap.fileinfo.get(inputLineInfo[0]);
                    if (inputFileInfo != null) {
                        newFrame = new StackTraceElement("[" + smap.firstStratum + "]", inputFileInfo.path, inputFileInfo.name, inputLineInfo[1]);
                    }
                }
            }
            if (newFrame != null) {
                if (newElements == null) {
                    newElements = new ArrayList<StackTraceElement>(Arrays.asList(elements).subList(0, i));
                }
                if (keepOriginalFrames)
                    newElements.add(elements[i]);
                newElements.add(newFrame);
            } else if (newElements != null) {
                newElements.add(elements[i]);
            }
        }
        if (newElements != null) {
            t.setStackTrace(newElements.toArray(new StackTraceElement[newElements.size()]));
        }
        if (t.getCause() != null)
            enhanceStackTrace(t.getCause(), cache, cl, keepOriginalFrames, packageNames);
    }

    /**
     * Extract source debug extension from a class file, provided as an input
     * stream
     * 
     * @param in
     *            Input stream to read the class file
     * @return Source debug extension as a String, or <code>null</code> if none
     *         was found.
     * @throws IOException
     *             if an I/O error occurs
     */
//    // ASM version of the same method:
//    private static String extractSourceDebugExtension0(InputStream in) throws IOException {
//        ClassReader cr = new ClassReader(in);
//        final String[] result = new String[1];
//        cr.accept(new ClassVisitor(Opcodes.ASM4) {
//            @Override
//            public void visitSource(String source, String debug) {
//                result[0] = debug;
//            }
//        }, 0);
//        return result[0];
//    }
    private static String extractSourceDebugExtension(InputStream in) throws IOException {
        DataInputStream dis = new DataInputStream(in);
        boolean[] isSourceDebugExtension;
        dis.skipBytes(8);

        // read constant pool
        isSourceDebugExtension = new boolean[dis.readUnsignedShort()];
        int[] skipSizes = new int[] { 0, 0, 2, 4, 4, 0, 0, 2, 2, 4, 4, 4, 4, 2, 2, 3, 2, 2, 4 };
        for (int i = 1; i < isSourceDebugExtension.length; i++) {
            byte type = dis.readByte();
            int skipSize;
            if (type == 1) {
                String value = dis.readUTF();
                isSourceDebugExtension[i] = value.equals("SourceDebugExtension");
                skipSize = 0;
            } else if (type == 5 || type == 6) {
                skipSize = 8;
                i++;
            } else if (type > 1 && type < 19) {
                skipSize = skipSizes[type];
            } else {
                skipSize = 2;
            }
            dis.skipBytes(skipSize);
        }
        dis.skipBytes(6);
        int ifaces = dis.readUnsignedShort();
        dis.skipBytes(2 * ifaces);

        // skip fields and methods
        for (int k = 0; k < 2; k++) {
            int count = dis.readUnsignedShort();
            for (int i = 0; i < count; i++) {
                dis.skipBytes(6);
                int attrCount = dis.readUnsignedShort();
                for (int j = 0; j < attrCount; j++) {
                    dis.skipBytes(2);
                    int skip = dis.readInt();
                    dis.skipBytes(skip);
                }
            }
        }

        // read attributes and find SourceDebugExtension
        int attrCount = dis.readUnsignedShort();
        for (int i = 0; i < attrCount; i++) {
            int idx = dis.readUnsignedShort();
            int len = dis.readInt();
            if (isSourceDebugExtension[idx]) {
                byte[] buf = new byte[len];
                dis.readFully(buf);
                return new String(buf, "UTF-8");
            } else {
                dis.skipBytes(len);
            }
        }
        return null;
    }

    private final String generatedFileName, firstStratum;
    private final Map<Integer, FileInfo> fileinfo = new HashMap<Integer, FileInfo>();
    private final Map<Integer, int[]> reverseLineMapping = new HashMap<Integer, int[]>();

    private static final Pattern LINE_INFO_PATTERN = Pattern.compile("([0-9]+)(?:#([0-9]+))?(?:,([0-9]+))?:([0-9]+)(?:,([0-9]+))?");

    private SMAPSourceDebugExtension(String value) {
        String[] lines = value.split("\n");
        if (!lines[0].equals("SMAP") || !lines[3].startsWith("*S ") || !lines[4].equals("*F"))
            throw new IllegalArgumentException(value);
        generatedFileName = lines[1];
        firstStratum = lines[3].substring(3);
        int idx = 5;
        while (!lines[idx].startsWith("*")) {
            String infoline = lines[idx++], path = null;
            if (infoline.startsWith("+ ")) {
                path = lines[idx++];
                infoline = infoline.substring(2);
            }
            int pos = infoline.indexOf(" ");
            int filenum = Integer.parseInt(infoline.substring(0, pos));
            String name = infoline.substring(pos + 1);
            fileinfo.put(filenum, new FileInfo(name, path == null ? name : path));
        }
        if (lines[idx].equals("*L")) {
            idx++;
            int lastLFI = 0;
            while (!lines[idx].startsWith("*")) {
                Matcher m = LINE_INFO_PATTERN.matcher(lines[idx++]);
                if (!m.matches())
                    throw new IllegalArgumentException(lines[idx - 1]);
                int inputStartLine = Integer.parseInt(m.group(1));
                int lineFileID = m.group(2) == null ? lastLFI : Integer.parseInt(m.group(2));
                int repeatCount = m.group(3) == null ? 1 : Integer.parseInt(m.group(3));
                int outputStartLine = Integer.parseInt(m.group(4));
                int outputLineIncrement = m.group(5) == null ? 1 : Integer.parseInt(m.group(5));
                for (int i = 0; i < repeatCount; i++) {
                    int[] inputMapping = new int[] { lineFileID, inputStartLine + i };
                    int baseOL = outputStartLine + i * outputLineIncrement;
                    for (int ol = baseOL; ol < baseOL + outputLineIncrement; ol++) {
                        if (!reverseLineMapping.containsKey(ol))
                            reverseLineMapping.put(ol, inputMapping);
                    }
                }
                lastLFI = lineFileID;
            }
        }
    }

    private static class FileInfo {
        public final String name, path;

        public FileInfo(String name, String path) {
            this.name = name;
            this.path = path;
        }
    }
}