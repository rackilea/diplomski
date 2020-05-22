import java.io.*;
import java.util.Scanner;

public class StringOut
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("test.txt");
        Scanner in = new Scanner(file);
        String line;

        while (in.hasNextLine() == true)
        {
            line = in.nextLine();
            String parts[] = line.split(" ");
            System.out.println(parts[0]);
        }
    }
}