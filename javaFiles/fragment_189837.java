import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Foo {
   public static void main(String[] args) throws IOException {
      Process cmd = Runtime.getRuntime().exec("cmd.exe");

      final InputStream inStream = cmd.getInputStream();
      new Thread(new Runnable() {
         public void run() {
            InputStreamReader reader = new InputStreamReader(inStream);
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
               System.out.println(scan.nextLine());
            }
         }
      }).start();

      OutputStream outStream = cmd.getOutputStream();
      PrintWriter pWriter = new PrintWriter(outStream);
      pWriter.println("echo Hello World");
      pWriter.flush();
      pWriter.close();
   }
}