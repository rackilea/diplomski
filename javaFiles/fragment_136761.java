import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnZipFiles {
    private static final Logger _LOGGER = LoggerFactory.getLogger(UnZipFiles.class);

    public void unzipAll(String path) {
        String filName;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles(); 
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                filName = listOfFiles[i].getName();
                if (filName.endsWith(".zip") || filName.endsWith(".ZIP")) {
                    unZipFile(listOfFiles[i]);
                }
            }
        }
    }

    public static void main(String[] args) {

        UnZipFiles U = new UnZipFiles();
        U.unzipAll("PATH");

    }

    public void unZipFile(File zipFile) {
        byte[] buffer = new byte[1024];

        try {
            // create output directory is not exists
            File folder = new File("PATH");
            if (!folder.exists()) {
                folder.mkdir();
            }

            // get the zip file content
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
            // get the zipped file list entry
            ZipEntry ze = zis.getNextEntry();

            while (ze != null) {
               String fileName = ze.getName();
               File newFile = new File("PATH" + File.separator + fileName);

               if (_LOGGER.isDebugEnabled())
                   _LOGGER.debug("Unzipping file : {}", new Object[] {newFile.getAbsoluteFile()});

                // create all non exists folders
                // else you will hit FileNotFoundException for compressed folder
                new File(newFile.getParent()).mkdirs();

                FileOutputStream fos = new FileOutputStream(newFile);             

                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();   
                ze = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        } catch(IOException ex) {
            _LOGGER.error("Exception occurred while unzipping!", ex);
        }
    }
}