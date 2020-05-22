import java.io.*;

public class HedgeScore {
   private static final String FILE_PATH = "hedgescore.txt";

   public static void main(String[] args) {
      int totScore = 25;
      BufferedWriter bw = null;
      try {
         System.out.println("totscore=" + totScore);
         bw = new BufferedWriter(new FileWriter(new File(
               FILE_PATH)));
         bw.write(totScore);
         bw.write(System.getProperty("line.separator"));
         bw.flush();
      } catch (IOException f) {
         System.out.println(f.getMessage());
      } finally {
         if (bw != null) {
            try {
               bw.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }

      InputStream input = null;
      try {
         input = new FileInputStream(FILE_PATH);
         int data = 0;
         while ((data = input.read()) != -1) {
            System.out.println("data being read from file :" + data);
         }
         input.close();
      } catch (IOException f) {
         System.out.println(f.getMessage());
      } finally {
         if (input != null) {
            try {
               input.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
   }
}