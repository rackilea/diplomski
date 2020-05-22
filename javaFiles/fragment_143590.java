import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListLinks {

    public void scanForScript(ArrayList<String> pagesToCrawl, String scriptName){

        List<String> pagesWithoutScript = new ArrayList<>();
        List<String> pagesWithScript = new ArrayList<>();
        String searchTerm = scriptName;

        Response response;
        Document doc;

        for (String page : pagesToCrawl) {
            try {
                response = Jsoup.connect(page)
                        .userAgent(
                                "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36")
                        .followRedirects(true).ignoreHttpErrors(true).execute();

                if (response.statusCode() != 200) {
                    System.out.println(page + " returned " + response.statusCode()); // handle pages with 404 error
                    continue;
                }

                doc = response.parse();

                boolean containsScript = false;
                for (Element scriptElement : doc.select("script")) { // grab the script elements
                    if (scriptElement.toString().contains(searchTerm)) { // search for searchterm
                        containsScript = true;
                        break;
                    }
                }
                if (containsScript) { // store filtered pages
                    pagesWithScript.add(page);
                } else {
                    pagesWithoutScript.add(page);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nNumber of pages containing script: " + pagesWithScript.size());
        for (String page : pagesWithScript) {
            System.out.println(page);
        }
        System.out.println("\n" + "Number of pages not containing script:" + pagesWithoutScript.size());
        for (String page : pagesWithoutScript) {
            System.out.println(page);
        }
    }

    public static void main(String[] args) {

        ArrayList<String> pagesToCrawl = new ArrayList<>();
        pagesToCrawl.add("http://stackoverflow.com/q/39244584/1661938");
        pagesToCrawl.add("http://www.quickonlinetips.com/archives/2013/07/load-google-adsense-script-once/");
        pagesToCrawl.add("http://www.w3schools.com/cssref/css_selectors.asp");
        pagesToCrawl.add("http://www.apnapaisa.com/agent-registration/index.html");

        new ListLinks().scanForScript(pagesToCrawl, "adsbygoogle.js");

    }

}