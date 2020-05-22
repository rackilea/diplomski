import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DataFileFoo {
   private static final String DATA_FILE_PATH = "datafile.txt";
   private static final String DELIMITER = "|";
   private static final String SPLIT_REGEX = "\\|";

   public static void main(String[] args) {
      System.out.println("usingStringTokenizer()");
      usingStringTokenizer();

      System.out.println();
      System.out.println("usingStringSplit();");
      usingStringSplit();
   }

   public static void usingStringTokenizer() {
      File datafile = new File(DATA_FILE_PATH);
      try {
         FileInputStream fin = new FileInputStream(datafile);
         BufferedReader br = new BufferedReader(new InputStreamReader(fin));
         // extract column names
         String aLine = "";
         while ((aLine = br.readLine()) != null) {
            StringTokenizer st2 = new StringTokenizer(aLine, DELIMITER);
            while (st2.hasMoreTokens()) {
               System.out.print(st2.nextToken() + ", ");
            }
            System.out.println();

         }
         br.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static void usingStringSplit() {
      File datafile = new File(DATA_FILE_PATH);
      try {
         FileInputStream fin = new FileInputStream(datafile);
         BufferedReader br = new BufferedReader(new InputStreamReader(fin));
         // extract column names
         String aLine = "";
         while ((aLine = br.readLine()) != null) {
            String[] tokens = aLine.split(SPLIT_REGEX);
            for (String token : tokens) {
               System.out.print(token + ", ");
            }
            System.out.println();

         }
         br.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}