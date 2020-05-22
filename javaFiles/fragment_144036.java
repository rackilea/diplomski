import java.io.*;

public class StringConsole
{
    public static void main(String... args) throws IOException
    {
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (count < 5)
        {
            System.out.print("My Name : ");
            String message = br.readLine();
            count++;
        }   
    }
}