import java.io.File;

public class MainClass {

  public static void main(String args[]) {

    try {

      File oldFile = new File("/usr/bin/temp/");

      File newFile = new File("/usr/bin/hunter/temp");

      boolean result = oldFile.renameTo(newFile);

      System.out.println(result);
    } 
    catch (Exception e) 
    {
      e.printStackTrace();
    }