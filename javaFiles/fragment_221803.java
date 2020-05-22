import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.IOException;

public class ReadFromFile {

  public static List<String> getWords(String path) {
    try {
      List<String> lines = Files.readAllLines(Paths.get(path));
      List<String> words = new ArrayList<>();  //Use descriptive variable names!
      for (String line : lines) {
        for (String word : line.split("    ")) {
          words.add(word);
          System.out.println(word);
        }
      }
      return words;
    } catch (IOException e) {
      //handle exception
      return null;  //This is not advised
    }
  }

  public static void main(String[] args) {
    List<String> prescription_words = getWords("prescription.txt");
    List<String> medicaments_words = getWords("medicaments.txt");

    List<List<String>> list2d = new ArrayList();

    for (int idx=0; idx < medicaments_words.size(); idx++) {
      // Iterate through your medications and add them to your 2dArray
    }
  }
}