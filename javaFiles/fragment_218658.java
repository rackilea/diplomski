package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MyZip {

    public void zipFolder(Path base, File dest, Path zipFolder) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(dest);
                ZipOutputStream zos = new ZipOutputStream(fos)) {
            addFolderToZip(base.getParent(), base, zos, zipFolder);
        }
    }

    private void addFolderToZip(Path base, Path currentFolder, ZipOutputStream zos, Path zipFolder) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(currentFolder)) {
            for(Path path : stream) {
                Path relativePath = base != null ? base.relativize(path) : path;
                Path pathInZip = zipFolder != null ? zipFolder.resolve(relativePath) : relativePath;
                if(path.toFile().isDirectory()) {
                    zos.putNextEntry(new ZipEntry(pathInZip.toString() + "/"));
                    // recurse to sub directories
                    addFolderToZip(base, path, zos, zipFolder);
                } else {
                    addFileToZip(path, pathInZip, zos);
                }
            }
        }
    }

    private void addFileToZip(Path sourcePath, Path pathInZip, ZipOutputStream zos) throws IOException {
        byte[] buffer = new byte[1024];
        int length;
        try (FileInputStream fis = new FileInputStream(sourcePath.toFile())) {
            ZipEntry ze = new ZipEntry(pathInZip.toString());
            zos.putNextEntry(ze);
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }
        }
    }

}