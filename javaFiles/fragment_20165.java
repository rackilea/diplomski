import java.util.Scanner;

public class TestFoo {
   private static final String FILE_NAME = "data.txt";
   private static final String REGEX = "</?html>|</?b>|\"|,";

   public static void main(String[] args) {
      Scanner scan = new Scanner(new File(FILE_NAME));
      while (scan.hasNextLine()) {
         String line = scan.nextLine();
         String newLine = line.replaceAll(REGEX, "").trim();
         if (line.contains("html")) {
            System.out.println("Default Mut: " + newLine);
         } else {
            System.out.println("\t" + newLine);
         }
      }
   }
}