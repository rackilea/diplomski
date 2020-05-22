import static com.ui4j.api.browser.BrowserFactory.getWebKit;

import com.ui4j.api.browser.Page;

public class Main {

    public static void main(String[] args) {
        Page page = getWebKit().navigate("https://bing.com");
        String html = (String) page.executeScript("document.documentElement.innerHTML");
        System.out.println(html);
    }
}