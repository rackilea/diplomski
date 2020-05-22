package zip.extraction.error;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Demo {

    public static void main(String[] args) {

        FileOutputStream destinationZipOutputStream = null;
        try {
            destinationZipOutputStream = new FileOutputStream("/home/kasun/Downloads/sample/test/compress.zip");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ZipOutputStream updateZipOutputStream = new ZipOutputStream(destinationZipOutputStream);
        updateZipOutputStream.setLevel(ZipOutputStream.STORED);
        File sourceFile = new File("/home/kasun/Downloads/sample/resources");
        try {
            zipFile(sourceFile, "parentdir", updateZipOutputStream);
            updateZipOutputStream.close();
            destinationZipOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void zipFile(File fileToZip, String fileName, ZipOutputStream updateZipOutputStream) throws
            IOException {

        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            // Creating directories with in the zip file
/*          if (fileName.endsWith("/")) {
                updateZipOutputStream.putNextEntry(new ZipEntry(fileName));
                updateZipOutputStream.closeEntry();
            } else {
                updateZi`pOutputStream.putNextEntry(new ZipEntry(fileName + "/"));
                updateZipOutputStream.closeEntry();
            }*/
            File[] childFiles = fileToZip.listFiles();
            if (childFiles == null) {
                throw new IOException("IOException occurred when getting list of files of directory " +
                        fileToZip.toString());
            }
            for (File file : childFiles) {
                zipFile(file, fileName + "/" + file.getName(), updateZipOutputStream);
            }
        } else {
            // Creating files with in the zip file
            try (FileInputStream sourceInputStream = new FileInputStream(fileToZip)) {
                updateZipOutputStream.putNextEntry(new ZipEntry(fileName));
                byte[] buffer = new byte[1024];
                int length;
                while ((length = sourceInputStream.read(buffer)) > 0) {
                    updateZipOutputStream.write(buffer, 0, length);
                }
                updateZipOutputStream.closeEntry();
            }
        }
    }
}