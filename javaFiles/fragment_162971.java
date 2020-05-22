import java.io.*;

public class ReverseLines {
   public ReverseLines() {
   }

   public void reverse(BufferedReader br, int n) {
      try {            
         String line = br.readLine();
         if (n > 0) {
            reverse(br, n - 1);
            System.out.println(line);
         }             
      } catch (Exception e) {
         System.out.println(e);
      }
   }

   public static void main(String[] argv) {
      ReverseLines testReverse = new ReverseLines();
      File test = new File("money.txt");

      FileReader fr = new FileReader(test );
      BufferedReader br = new BufferedReader(fr); 

      testReverse.reverse(br, 3);
   }
}