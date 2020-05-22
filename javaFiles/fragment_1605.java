package test;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.bind.DatatypeConverter;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Scraper {

    public static void main(String[] args)
            throws FailingHttpStatusCodeException, MalformedURLException,
            IOException {
        WebClient webClient = new WebClient();

        String username = "user";
        String password = "pw";
        String authString = username + ":" + password;
        String authEncoded = DatatypeConverter.printBase64Binary(authString
                .getBytes());

        webClient.addRequestHeader("Authorization", "Basic " + authEncoded);

        HtmlPage page = webClient.getPage("http://qub.ac.uk/qol/");
        // System.out.println(page.asXml());
        DomNodeList<DomElement> headings = page.getElementsByTagName("h3");
        for (DomElement e : headings) {
            System.out.println("Got heading: " + e.getTextContent());
        }

    }

}