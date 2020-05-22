import java.io.BufferedWriter; <br>
import java.io.File;<br>
import java.io.FileWriter;<br>
import java.util.Scanner;<br>

public class ConcatFiles
{
    public static String masterFile;


public static void main(String[] args) throws Exception
{
    MasterFile();
}

public static void MasterFile() throws Exception
{
    System.out.println("Enter Master File Name:");
    Scanner readMasterFileName = new Scanner(System.in);
    masterFile = readMasterFileName.next();
    if (new File(masterFile).exists() && masterFile.contains(".txt"))
    readFileName();
    else
    {
        if (masterFile.contains(".txt"))
        {
            new File(masterFile).createNewFile();
            System.out.println("Master File Created");
            readFileName();
        }
        else
        {
            System.out.println("Invalid File or Input");
            MasterFile();
        }
    }
}
public static void readFileName() throws Exception
{
    System.out.println("Enter File Names:");
    Scanner readOtherFiles = new Scanner(System.in);
    String cmd = readOtherFiles.next();

    if (cmd.equalsIgnoreCase("Exit"))
        System.exit(0);
    else
        if (cmd.equalsIgnoreCase("New"))
            MasterFile();
        else
            if (cmd.contains(".txt") && new File(cmd).exists())
            concatFile(cmd);
            else
            {
                System.out.println("Invalid Input or File");
                readFileName();
            }
}
public static void concatFile(String otherFiles)throws Exception
{
    BufferedWriter out = new BufferedWriter(new FileWriter(masterFile, true));
    File readFiles = new File(otherFiles);
    Scanner reader = new Scanner(readFiles);
    while(reader.hasNext())
    {
        out.write(reader.nextLine()+"\n");
    }
    out.close();
    readFileName();
}
}