import java.io.IOException;

public class Tester
{
    public static void main(String args[])
        throws IOException
    {
        int ch;
        while ((ch = System.in.read()) != -1)
        {
            if (ch != '\n' && ch != '\r')
            {
                processChar((char)ch);
            }
        }
    }


    private static void processChar(char c)
    {
        // do stuff
        System.out.println("Processing: '" + c + "'");
    }

}