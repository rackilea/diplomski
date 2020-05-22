import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class SO27938637 {
    public static void main(String[] args) {
        Document doc = Jsoup.parse("<div><span><div><b>sdf</span>dsf<i>sdfdsfsdfds<span></div><div>\n    <input id=\"_NAME\" value=\"/John/\" />\n   <input id=\"_LASTNAME\" value=\"/BOND/\"/>\n   <input id=\"_Class\"   value=\"5\" /></div>");
        Elements inputElement = doc.select("input");

        for (Element e: inputElement) {
            System.out.println(e.attr("id") + ": " + e.attr("value"));
        }
    }
}