import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class JsoupParser4 {

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.parse(new File("mob.html"), "UTF-8");
            Document noFramesDoc = Jsoup.parseBodyFragment(doc.select("noframes").text());
            System.out.println("Age = " + noFramesDoc.select("input[id=age]").attr("value"));
            System.out.println("Class = " + noFramesDoc.select("input[id=class]").attr("value"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}