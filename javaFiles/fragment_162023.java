import java.io.*;

public class TestProcess {
    public static void main(String[] args)
        throws InterruptedException, IOException
    {
       ProcessBuilder pb = new ProcessBuilder(
           "python", absolutePath, params
       );
       Process ps = pb.start();

       BufferedReader reader = new BufferedReader(
           new InputStreamReader(ps.getInputStream())
       );

       String inputLine;
       while ((inputLine = reader.readLine()) != null) {
               System.out.println(inputLine);
       }

       ps.waitFor();
       int ec = ps.exitValue();
       System.out.println("Child returned " + ec);
   }
}