import javax.activation.MimetypesFileTypeMap;
import java.io.File;

class GetMimeType {
  public static void main(String args[]) {
    File f = new File(filePath);
    System.out.println("Mime Type of " + f.getName() + " is " +
                         new MimetypesFileTypeMap().getContentType(f));

}