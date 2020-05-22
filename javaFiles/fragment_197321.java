package org.test.zip;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        ZipInputStream is = new ZipInputStream(new SequenceInputStream(Collections.enumeration(
            Arrays.asList(new FileInputStream("test.zip.001"), new FileInputStream("test.zip.002"), new FileInputStream("test.zip.003")))));
        try {
            for(ZipEntry entry = null; (entry = is.getNextEntry()) != null; ) {
                OutputStream os = new BufferedOutputStream(new FileOutputStream(entry.getName()));
                try {
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for(int readBytes = -1; (readBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
                        os.write(buffer, 0, readBytes);
                    }
                    os.flush();
                } finally {
                    os.close();
                }
            }
        } finally {
            is.close();
        }
    }
}