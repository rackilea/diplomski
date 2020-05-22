import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import java.io.File;
import java.io.IOException;

public class FilePropertiesTest {

    public static void main(String[] args) {
        File file = new File("/Users/name/folder/test.png");

        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            print(metadata);
        } catch (ImageProcessingException e) {
            // handle exception
        } catch (IOException e) {
            // handle exception
        }
    }

    private static void print(Metadata metadata) {
        System.out.println("-------------------------------------");

        for (Directory directory : metadata.getDirectories()) {
            // Each Directory stores values in Tag objects
            for (Tag tag : directory.getTags()) {
                System.out.println(tag);
            }

            // Each Directory may also contain error messages
            if (directory.hasErrors()) {
                for (String error : directory.getErrors()) {
                    System.err.println("ERROR: " + error);
                }
            }
        }
    }
}