import java.io.*;

public class HedgeScore2 {
   private static final String FILE_PATH = "hedgescore.txt";

   public static void main(String[] args) {
      int totScore = 25;
      PrintWriter pw = null;
      try {
         System.out.println("totscore=" + totScore);
         pw = new PrintWriter(new FileWriter(new File(FILE_PATH)));
         pw.write(String.valueOf(totScore));
         pw.write(System.getProperty("line.separator"));
         pw.flush();
      } catch (IOException f) {
         System.out.println(f.getMessage());
      } finally {
         if (pw != null) {
            pw.close();
         }
      }

      BufferedReader reader = null;
      try {
         reader = new BufferedReader(new FileReader(FILE_PATH));
         String line = null;
         while ((line = reader.readLine()) != null) {
            System.out.println(line);
         }
      } catch (IOException f) {
         System.out.println(f.getMessage());
      } finally {
         if (reader != null) {
            try {
               reader.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
   }
}