import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class EchoCaller2 {
   private static final String AUTO_IT_ECHOER = "Echoer.exe"; // AutoIt program
   private static Scanner scan = null;
   private static PrintStream out = null;

   public static void main(String[] args) throws IOException,
         InterruptedException {
      ProcessBuilder pb2 = new ProcessBuilder(AUTO_IT_ECHOER);
      pb2.redirectErrorStream();
      Process p = pb2.start();
      scan = new Scanner(p.getInputStream());
      out = new PrintStream(new BufferedOutputStream(p.getOutputStream()));

      new Thread(new Runnable() {
         public void run() {
            while (scan.hasNextLine()) {
               System.out.println(scan.nextLine());
            }
            scan.close();
         }
      }).start();

      for (int i = 0; i < 10; i++) {
         out.println("(" + i + ") to autoit ");
         out.flush();
      }

      out.println("exit ");
      out.flush();
      out.close();
   }
}