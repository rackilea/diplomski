@Grapes(
    @Grab(group='net.sourceforge.htmlunit', module='htmlunit', version='2.8')
)

import com.gargoylesoftware.htmlunit.*
import com.gargoylesoftware.htmlunit.html.*

URL url = new URL("http://www.example.com");
StringWebResponse response = new StringWebResponse("<html><head><title>Test</title></head><body></body></html>", url);
WebClient client = new WebClient()
HtmlPage page = HTMLParser.parseHtml(response, client.getCurrentWindow());
System.out.println(page.getTitleText());