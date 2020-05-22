import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) throws Exception {
        String html =   "<div>"+
                               "<img class=\"absmiddle-blah foo-bar\" src=\"google.com/image.png\" \\>"+
                               "<img class=\"absmiddle-blah2 foo-bar2\" src=\"google.com/image.png\" \\>"+
                               "<img class=\"ablehe-bla2h foo-bar3\" src=\"google.com/image.png\" \\>"+
                               "<img class=\"absmiddle-bl2ah foo-bar4\" src=\"google.com/image.png\" \\>"+
                               "<img class=\"blah-bl2ah foo-bar4\" src=\"google.com/image.png\" \\>"+
                               "<img class=\"absmiddle-bl2ah foo-bar4\" src=\"google.com/image.png\" \\>"+
                               "<img class=\"sdfdle-bl2ah foo-bar4\" src=\"google.com/image.png\" \\>"+
                        "</div>";

        Document doc = Jsoup.parse(html);
        Elements els = doc.select("img[class*=absmiddle]");
        System.out.println(els);
    }
}