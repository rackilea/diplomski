import java.io.*;

public class CheckName
{
  private static boolean doesNameExistInFile(String name, String filename)
    throws FileNotFoundException, IOException
  {
    BufferedReader reader = new BufferedReader(new FileReader(filename));

    String line = null;

    try {
      while ((line = reader.readLine()) != null) {
        if (line.equals(name))
          return true;
      }

    } finally {
      // Always close() before exiting.
      reader.close();
    }

    return false;
  }

  public static void main(String[] args)
    throws FileNotFoundException, IOException
  {
    boolean exists = doesNameExistInFile("Bender", "input.txt");

    System.out.println(exists ? "Exists!" : "Does not exist.");
  }
}