import java.io.File;
import java.io.IOException;

public class FileUtils {
  public static boolean isFilenameValid(String file) {
    File f = new File(file);
    try {
       f.getCanonicalPath();
       return true;
    }
    catch (IOException e) {
       return false;
    }
  }

  public static void main(String args[]) throws Exception {
    // true
    System.out.println(FileUtils.isFilenameValid("well.txt"));
    System.out.println(FileUtils.isFilenameValid("well well.txt"));
    System.out.println(FileUtils.isFilenameValid(""));

    //false
    System.out.println(FileUtils.isFilenameValid("test.T*T"));
    System.out.println(FileUtils.isFilenameValid("test|.TXT"));
    System.out.println(FileUtils.isFilenameValid("te?st.TXT"));
    System.out.println(FileUtils.isFilenameValid("con.TXT")); // windows
    System.out.println(FileUtils.isFilenameValid("prn.TXT")); // windows
    }
  }