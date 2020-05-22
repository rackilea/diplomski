import java.io.*;

public class TestMain {
   private static final String JAVA_CMD = "java";
   private static final String CP = "-cp";

   // *** your CLASS_PATH and PROG Strings will of course be different ***
   private static final String CLASS_PATH = "C:/Users/hovercraft/Documents/workspace/Yr 2012A/bin";
   private static final String PROG = "yr12.m07.b.Test2";

   private static final String[] CMD_ARRAY = { JAVA_CMD, CP, CLASS_PATH, PROG };

   public static void main(String[] args) {
      new Thread(new Runnable() {
         public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                  System.in));
            String command = null;
            try {
               while ((command = reader.readLine()) != null) {
                  System.out.println("Command Received:" + command);
               }
            } catch (Exception ex) {
               ex.printStackTrace();
               // failed to listening command
            }

         }
      }).start();
      Process process = null;
      try {
         ProcessBuilder processBuilder = new ProcessBuilder(CMD_ARRAY);
         process = processBuilder.start();
         InputStream inputStream = process.getInputStream();
         setUpStreamGobbler(inputStream, System.out);

         InputStream errorStream = process.getErrorStream();
         setUpStreamGobbler(errorStream, System.err);

         System.out.println("never returns");
         process.waitFor();
      } catch (IOException e) {
         throw new RuntimeException(e);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }

   public static void setUpStreamGobbler(final InputStream is, final PrintStream ps) {
      final InputStreamReader streamReader = new InputStreamReader(is);
      new Thread(new Runnable() {
         public void run() {
            BufferedReader br = new BufferedReader(streamReader);
            String line = null;
            try {
               while ((line = br.readLine()) != null) {
                  ps.println("process stream: " + line);
               }
            } catch (IOException e) {
               e.printStackTrace();
            } finally {
               try {
                  br.close();
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }
         }
      }).start();
   }
}