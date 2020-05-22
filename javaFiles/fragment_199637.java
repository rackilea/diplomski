import java.io.*;

class FileOutputDemo 
{   

        public static void main(String args[])
        {              
                FileOutputStream out; // declare a file output object
                PrintStream p; // declare a print stream object

                try
                {
                        // Create a new file output stream
                        // connected to "boot.ini"
                        out = new FileOutputStream("boot.ini");

                        // Connect print stream to the output stream
                        p = new PrintStream( out );

                        p.println ("This is written to a file");

                        p.close();
                }
                catch (Exception e)
                {
                        System.err.println ("Error writing to file");
                }
        }
}