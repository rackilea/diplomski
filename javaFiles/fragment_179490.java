import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ScrapperApp {

    private static void go() throws Exception {
        /* turn off annoying htmlunit warnings */
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);

        HtmlPage nextPage;
        String url = "http://media.ethics.ga.gov/search/Campaign/Campaign_Name.aspx?NameID=5751&FilerID=C2009000085&Type=candidate";

        final WebClient webclient = new WebClient(BrowserVersion.CHROME);
        final HtmlPage page = webclient.getPage(url);

        System.out.println("PULLING LINKS:");

        List<HtmlAnchor> articles = (List<HtmlAnchor>) page.getByXPath("//a[@class='lblentrylink']");
        //List<HtmlAnchor> articles = (List<HtmlAnchor>) page.getByXPath("//div[@class='hform1']/a[@class='lblentrylink']");

        for(int x=0; x<articles.size(); x++) {
            System.out.println("Clicking "+articles.get(x).asText());
            //nextPage = articles.get(x).click();
            //System.out.println(nextPage.getBody());
        }
    }
    public static void main(String[] args) throws Exception {
        go();
        System.out.println("COMPLETE");
    }
}