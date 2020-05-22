import java.io.File;
import java.util.ArrayList;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class CreateSplitZipFile {

    public CreateSplitZipFile() {

        try {
            // Initiate ZipFile object with the path/name of the zip file.
            ZipFile zipFile = new ZipFile("c:\\ZipTest\\CreateSplitZipFile.zip");

            // Build the list of files to be added in the array list
            // Objects of type File have to be added to the ArrayList
            ArrayList filesToAdd = new ArrayList();
            filesToAdd.add(new File("c:\\ZipTest\\sample.txt"));
            filesToAdd.add(new File("c:\\ZipTest\\myvideo.avi"));
            filesToAdd.add(new File("c:\\ZipTest\\mysong.mp3"));

            // Initiate Zip Parameters which define various properties such
            // as compression method, etc.
            ZipParameters parameters = new ZipParameters();

            // set compression method to store compression
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);

            // Set the compression level. This value has to be in between 0 to 9
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

            // Create a split file by setting splitArchive parameter to true
            // and specifying the splitLength. SplitLenth has to be greater than
            // 65536 bytes
            // Please note: If the zip file already exists, then this method throws an 
            // exception
            zipFile.createZipFile(filesToAdd, parameters, true, 10485760);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new CreateSplitZipFile();
    }

}