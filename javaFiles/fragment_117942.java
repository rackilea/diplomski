package sandbox.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsoupMain {
    private final String HTML = "<div class=\"cloud recommended\">\n" +
            "    <div id=\"bigcloud\" class=\"eventwithfoto\">\n" +
            "        <h1>Artist Name</h1>\n" +
            "        <div id=\"eventphoto\">\n" +
            "            <a href=\"http://linkToPhoto.jpg\" target=\"_top\" rel=\"lightbox\"><img src=\"http://linkToPhoto.jpg\" height=\"150\"></a>\n" +
            "        </div>\n" +
            "\n" +
            "        <div id=\"eventmain\" style=\"margin-top: 12px;\">\n" +
            "            <p id=\"eventwhere\"><span><b>Name of place<br></b></span><span>Address of place</span>\n" +
            "            <br> tel.: +48 111 222 111 <br><a href=\"http://www.linktoplace.com\" target=\"_blank\">http://www.linktoplace.com</a> </p>\n" +
            "            <p id=\"eventdate\">2017-04-20 godz. 20:00</p>\n" +
            "\n" +
            "\n" +
            "            <div id=\"eventadmission\">\n" +
            "                120 zł\n" +
            "            </div>\n" +
            "\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"clear\"></div>\n" +
            "        <div id=\"eventdesc\">\n" +
            "            Here is some descr<br/>Some other descr \n" +
            "            <div class=\"clear\"></div>\n" +
            "\n" +
            "            <br>\n" +
            "                <a href=\"http://link.com\" target=\"_blank\">link to event</a>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>";

    public static void main(String[] args) {
        new JsoupMain().findTwoSpans();
    }

    private void findTwoSpans() {
        Document doc = Jsoup.parse(HTML);
        Element eventWhere = doc.getElementById("eventwhere");
        Elements spans = eventWhere.select("span");
        System.out.println("span[0]="+spans.get(0).text());
        Element spanTwo = spans.get(1);
        System.out.println("span[1]="+spanTwo.text());

        // Get phone
        Element eventMain = doc.getElementById("eventmain");
        String textMain = eventMain.after(spanTwo).after("br").text();

        int beginPos = textMain.indexOf("tel.: ");
        int endPos = textMain.indexOf(" http://");
        if (beginPos>0 && endPos>0) {
            String phone = textMain.substring(beginPos+6, endPos);
            System.out.println("Found phone: "+phone);
        }
        else {
            System.out.println("Phone not found: "+textMain);
        }
    }
}