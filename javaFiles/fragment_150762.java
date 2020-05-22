import java.io.*;
import java.util.Scanner;
public class FileIO
{
  public static void main(String[] args) throws IOException
  {
     Scanner kb = new Scanner(System.in);
     System.out.println("Enter input filename: ");
     String fileName = kb.nextLine();
     File file = new File(fileName);
     if (!file.exists())
     {
        System.out.println("File not found.");
        System.exit(0);
     }
     Scanner inFile = new Scanner(file);

     // Open both output files
     System.out.println("Enter output filename: ");
     String outFileName = kb.nextLine();
     PrintWriter outFile = new PrintWriter(outFileName);

     System.out.println("Enter another output filename (append): ");
     String appFileName = kb.nextLine();
     FileWriter fw = new FileWriter(appFileName, true);
     PrintWriter appFile = new PrintWriter(fw);

     while (inFile.hasNext())
     {
        String str = inFile.nextLine();
        String upperCase = str.toUpperCase();
        // Write each input line to both output files at the same time
        outFile.println(upperCase);
        appFile.println(str);
     }
     inFile.close();
     outFile.close();
     appFile.close();

     System.out.println("Data written to \"" + outFileName + "\" and \""
                        + appFileName + ".\"");
     }
  }