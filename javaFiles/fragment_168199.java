package de.scrum_master.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTool {
    public void addToZip(File zipFile, File... filesToAdd) throws IOException {
        try (
            FileOutputStream fos = new FileOutputStream(zipFile.getAbsoluteFile());
            ZipOutputStream zos = new ZipOutputStream(fos)
        ) {
            final byte[] buffer = new byte[1024];
            for (File fileToAdd : filesToAdd) {
                ZipEntry entry = new ZipEntry(fileToAdd.getName());
                if (fileToAdd.getName().endsWith(".zip")) {
                    entry.setMethod(ZipEntry.STORED);
                    long fileSize = fileToAdd.length();
                    entry.setSize(fileSize);
                    entry.setCompressedSize(fileSize);
                    CRC32 crc32 = new CRC32();
                    try (FileInputStream in = new FileInputStream(fileToAdd.getAbsoluteFile())) {
                        int len;
                        while ((len = in.read(buffer)) > 0) {
                            crc32.update(buffer, 0, len);
                        }
                    }
                    entry.setCrc(crc32.getValue());
                }
                zos.putNextEntry(entry);
                try (FileInputStream in = new FileInputStream(fileToAdd.getAbsoluteFile())) {
                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                }
                zos.closeEntry();
            }
        }
    }
}