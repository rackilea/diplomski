import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SOQuestion {

   private static void fileCommand(String file) throws IOException {
       Path pathFile = Paths.get(file);
       List<String> allLines = Files.readAllLines(pathFile, StandardCharsets.UTF_8);
       for (String line : allLines) {
           if (line.toUpperCase().startsWith("ADD")) {
               addBook(line);
           }
       }
   }

   private static void addBook(String line) {
       //Do your thing here
       System.out.println("command: "+line);
   }

   public static void main(String[] args) throws IOException {
      fileCommand("e:/test.csv"); //just for my testing, change to your stuff
   }
}