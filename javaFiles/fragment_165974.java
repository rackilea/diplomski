import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JSoupTest {

    @Test
    public void testJSoup() throws IOException {
        String html = "http://beta.letsplaysoccer.com/facilities/26/teams/187822";

        Document doc = Jsoup.connect(html).get();
        Elements tableElements = doc.select("table");

        Element firstTable = tableElements.get(0);

        List<Node> firstTableRows = firstTable.childNodes().get(1).childNodes();
        int numRows = firstTableRows.size();
        // skip first row as header
        for (int i = 1; i < numRows; i++) {
            Node row = firstTableRows.get(i);
            if (row instanceof Element) {
                Node homeTeam = row.childNode(5).childNode(1).childNode(0);
                Node visitorTeam = row.childNode(7).childNode(1).childNode(0);
                // some are in bold
                if(visitorTeam.childNodeSize() > 0 ){
                    visitorTeam = visitorTeam.childNode(0);
                }
                Node score = row.childNode(9).childNode(0);
                System.out.println(homeTeam + " vs " + visitorTeam + ": " + score);
            }
        }

    }
}