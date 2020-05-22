import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

class Scratch {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        final String document = "<?xml version=\"1.0\"?>\n" +
                "<rss version=\"2.0\" xmlns:atom=\"http://www.w3.org/2005/Atom\">\n" +
                " <channel>\n" +
                "  <title>Torrentz - ubuntu</title>\n" +
                "  <link>http://torrentz.eu/verified?q=ubuntu</link>\n" +
                "  <description>ubuntu search</description>\n" +
                "  <language>en-us</language>\n" +
                "  <atom:link href=\"http://torrentz.eu/feed_verifiedP?q=ubuntu\" rel=\"self\" type=\"application/rss+xml\" />\n" +
                "  <item>\n" +
                "     <title>ubuntu 11 10 desktop i386 iso</title>\n" +
                "     <link>http://torrentz.eu/8ac3731ad4b039c05393b5404afa6e7397810b41</link>\n" +
                "     <guid>http://torrentz.eu/8ac3731ad4b039c05393b5404afa6e7397810b41</guid>\n" +
                "     <pubDate>Thu, 13 Oct 2011 15:02:06 +0000</pubDate>\n" +
                "     <category>apps linux applications os software</category>\n" +
                "     <description>Size: 695 MB Seeds: 4,613 Peers: 161 Hash: 8ac3731ad4b039c05393b5404afa6e7397810b41</description>\n" +
                "  </item>\n" +
                " </channel>\n" +
                "</rss>\n";

        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        XMLReader xr = sp.getXMLReader();

        ContentHandler torrentsHandler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.printf("%s / %s / %s\n", uri, localName, qName);
            }
        };
        xr.setContentHandler(torrentsHandler);
        xr.parse(new InputSource(new StringReader(document)));
    }
}