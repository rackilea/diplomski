import java.io.File;
import java.io.IOException;

import com.sun.jna.platform.FileUtils;

public class MoveToTrash {

  public static void main(String[] args){
    FileUtils fileUtils = FileUtils.getInstance();
    if (fileUtils.hasTrash()) {
        try {
            fileUtils.moveToTrash( new File[] {new File("c:/folder/abcd.txt") });                
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    else {
        System.out.println("No Trash available");
    }
}
}