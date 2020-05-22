import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ProcessEg {
   private static Process p;

   public static void main(String[] args) {
      String[] commands = {"cmd", "/c", "dir"};
      ProcessBuilder pBuilder = new ProcessBuilder(commands);
      pBuilder.redirectErrorStream();

      try {
         p = pBuilder.start();
         InputStream in = p.getInputStream();
         final Scanner scanner = new Scanner(in);
         new Thread(new Runnable() {
            public void run() {
               while (scanner.hasNextLine()) {
                  System.out.println(scanner.nextLine());
               }
               scanner.close();
            }
         }).start();
      } catch (IOException e) {
         e.printStackTrace();
      }
      try {
         int result = p.waitFor();
         p.destroy();
         System.out.println("exit result: " + result);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}