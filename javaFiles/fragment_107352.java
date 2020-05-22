import java.io.BufferedReader;

   import java.io.IOException;

   import java.io.InputStream;

   import java.io.InputStreamReader;

   import java.io.File;



   public class Execute
   {

    public static void main (String args[])
    {

     String command="/bin/bash loop_shell.sh"; ----> change in shell command!

     String output=executeCommand1(command);

     System.out.println(output);
    }
        public static String executeCommand1(String command) {

            StringBuffer output = new StringBuffer();

            Process p;

            try {
                File dir = new File("/home/vamz/Desktop/sudhir_personal/JAVA_IMPORTANT/");//path
                p = Runtime.getRuntime().exec(command,null,dir);
                p.waitFor();
                BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));

                            String line = "";           
                while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
                }

            } catch (Exception e) {
        e.printStackTrace();
        }

    return output.toString();

    }

  }