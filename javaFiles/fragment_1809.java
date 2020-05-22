import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

public static void main(String[] args) {

Path wiki_path = Paths.get(path, "TestSheet.csv");

Charset charset = Charset.forName("ISO-8859-1");
try {
  List<String> lines = Files.readAllLines(wiki_path, charset);
  int i = 0;
  for (String line : lines) {
    if (i>8) {
        String temp = line.substring(line.indexOf(',',line.indexOf(',')+1)+1);
        temp = temp.substring(0,temp.indexOf(','));
        System.out.println(temp);
    }
    i++;
  }
} catch (IOException e) {
  System.out.println(e);
}

}
}