package net.fish;

import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseXML {

    private static final DocumentBuilderFactory DOCUMENT_BUILDER_FACTORY = DocumentBuilderFactory.newInstance();
    private static final XPathFactory XPATH_FACTORY = XPathFactory.newInstance();

    public static void main(String[] args) throws Exception {
        new ParseXML().parseXml("http://ws.audioscrobbler.com/2.0/?method=chart.gethypedtracks&api_key=1732077d6772048ccc671c754061cb18&limit=10");
    }

    private void parseXml(String urlPath) throws Exception {
        URL url = new URL(urlPath);
        URLConnection connection = url.openConnection();
        DocumentBuilder db = DOCUMENT_BUILDER_FACTORY.newDocumentBuilder();

        final Document document = db.parse(connection.getInputStream());
        XPath xPathEvaluator = XPATH_FACTORY.newXPath();
        XPathExpression nameExpr = xPathEvaluator.compile("lfm/tracks/track/name");
        NodeList trackNameNodes = (NodeList) nameExpr.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < trackNameNodes.getLength(); i++) {
            Node trackNameNode = trackNameNodes.item(i);
            System.out.println(String.format("Track Name: %s" , trackNameNode.getTextContent()));
            XPathExpression artistNameExpr = xPathEvaluator.compile("following-sibling::artist/name");
            NodeList artistNameNodes = (NodeList) artistNameExpr.evaluate(trackNameNode, XPathConstants.NODESET);
            for (int j=0; j < artistNameNodes.getLength(); j++) {
                System.out.println(String.format(" - Artist Name: %s", artistNameNodes.item(j).getTextContent()));
            }
        }
    }
}