package com.github.davidepastore.stackoverflow34014436;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.text.BadLocationException;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Stackoverflow 34014436 question.
 *
 */
public class App {
    public static void main(String[] args) throws URISyntaxException,
            IOException, BadLocationException {
        HTMLDocument doc = new HTMLDocument() {
            public HTMLEditorKit.ParserCallback getReader(int pos) {
                return new HTMLEditorKit.ParserCallback() {
                    public void handleText(char[] data, int pos) {
                        System.out.println(data);
                    }
                };
            }
        };

        URL url = new URI("http://tamilblog.ishafoundation.org/").toURL();
        URLConnection conn = url.openConnection();
        Reader rd = new InputStreamReader(conn.getInputStream());
        OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream("ram.txt"), "UTF-8");

        EditorKit kit = new HTMLEditorKit();
        kit.read(rd, doc, 0);
        try {
            Document docs = Jsoup.connect(
                    "http://tamilblog.ishafoundation.org/").get();

            Elements links = docs.select("a[href]");

            Elements elements = docs.select("*");
            System.out.println("Total Links :" + links.size());

            for (Element element : elements) {
                System.out.println(element.ownText());
            }
            for (Element link : links) {
                String hrefUrl = link.attr("href");
                if (!"#".equals(hrefUrl) && !hrefUrl.isEmpty()) {
                    System.out.println(" * a: link :" + hrefUrl);
                    System.out.println(" * a: text :" + link.text());
                    writer.write(link.text() + " => " + hrefUrl + "\n");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}