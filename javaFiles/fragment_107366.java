import java.io.File;
import java.util.Date;
import java.util.List;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.util.Zip4jUtil;


public class ExtractWithoutOverwriting {

    public static void main(String[] args) {

        try {
            String outputPath = "yourOutputPath";
            ZipFile zipFile = new ZipFile(new File("yourZipFile.zip"));
            if (zipFile.isEncrypted()) {
                zipFile.setPassword("yourPassword".toCharArray());
            }

            @SuppressWarnings("unchecked")
            List<FileHeader> fileHeaders = zipFile.getFileHeaders();

            for (FileHeader fileHeader : fileHeaders) {
                if (fileHeader.isDirectory()) {
                    File file = new File(outputPath + System.getProperty("file.separator") + fileHeader.getFileName());
                    file.mkdirs();
                } else {
                    if (canWrite(outputPath, fileHeader)) {
                        System.out.println("Writing file: " + fileHeader.getFileName());
                        zipFile.extractFile(fileHeader, outputPath);
                    } else {
                        System.out.println("Not writing file: " + fileHeader.getFileName());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static boolean canWrite(String outputPath, FileHeader fileHeader) {
        File file = new File(outputPath + System.getProperty("file.separator") + fileHeader.getFileName());
        //time stamps are stored in dos format in a zip file
        //convert it to java format
        long lastModifiedFromZip = Zip4jUtil.dosToJavaTme(fileHeader.getLastModFileTime());

        //If the file exists, it can be overwritten only if the file in the destination path
        //is newer than the one in the zip file
        return !(file.exists() && isLastModifiedDateFromFileNewer(file.lastModified(), lastModifiedFromZip));
    }

    public static boolean isLastModifiedDateFromFileNewer(long lastModifiedFromFile, long lastModifiedFromZip) {
        Date lastModifiedDateFromFile = new Date(lastModifiedFromFile);
        Date lastModifiedDateFromZip = new Date(lastModifiedFromZip);

        return lastModifiedDateFromFile.after(lastModifiedDateFromZip);
    }

}