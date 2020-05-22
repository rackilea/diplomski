import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.exception.ZipExceptionConstants;
import net.lingala.zip4j.model.FileHeader;

public class VerifyPassword {

    public static void verify() {
        try {
            ZipFile zipFile = new ZipFile(new File("myZip.zip"));
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(new char[] {'t', 'e', 's', 't'});
            }
            List<FileHeader> fileHeaders = zipFile.getFileHeaders();

            for(FileHeader fileHeader : fileHeaders) {
                try {
                    InputStream is = zipFile.getInputStream(fileHeader);
                    byte[] b = new byte[4 * 4096];
                    while (is.read(b) != -1) {
                        //Do nothing as we just want to verify password
                    }
                    is.close();
                } catch (ZipException e) {
                    if (e.getCode() == ZipExceptionConstants.WRONG_PASSWORD) {
                        System.out.println("Wrong password");
                    } else {
                        //Corrupt file
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                     System.out.println("Most probably wrong password.");
                     e.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.out.println("Some other exception occurred");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        verify();
    }

}