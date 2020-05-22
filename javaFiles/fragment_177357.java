import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Foo {
   public static void main(String[] args) throws IOException {
      Scanner scan = new Scanner(Foo.class.getResourceAsStream("Foo.txt"));
      String text = "";
      while (scan.hasNextLine()) {
         text += scan.nextLine() + "\n";
      }
      Document doc = Jsoup.parse(text);

      Elements eles = doc.select("div.class_one.class_two.class_three.classfour.classfive.classsix");
      System.out.println(eles);
   }
}