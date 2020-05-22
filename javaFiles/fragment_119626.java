import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Test {
    public static void main(String[] args) {
        final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
        HtmlPage page = null;
        try {
            page = webClient.getPage("https://docs.angularjs.org/api/ng/service/$http");
        } catch (Exception e) {}

        System.out.println(page.asXml());
        webClient.closeAllWindows();
    }
}