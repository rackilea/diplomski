import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class SmallDisk {

    final static String SMALL_DISK_PATH = "/Volumes/smallDisk";

    final static Pattern NO_SPACE_LEFT = Pattern.compile(": No space left on device$");

    public static void main(String[] args) throws NoSpaceException {
        Path p = Paths.get(SMALL_DISK_PATH);
        FileStore fs = null;
        try {
            fs = Files.getFileStore(p);
            System.out.println(fs.getUsableSpace());
            Path newFile = Paths.get(SMALL_DISK_PATH + "/newFile");
            Files.createFile(newFile);

        } catch (FileSystemException e) {
            //We catch the "No space left on device" from the FileSystemException and propagate it
            if(NO_SPACE_LEFT.matcher(e.getMessage()).find()){
                throw new NoSpaceException("Not enough space");
            }
            //Propagate exception or deal with it here
        } catch (IOException e) {
            //Propagate exception or deal with it here
        }

    }

    public static class NoSpaceException extends IOException{

        public NoSpaceException(String message) {
            super(message);
        }
    }
}