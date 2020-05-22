package com.github.davidepastore.stackoverflow35436825;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

/**
 * Stackoverflow 35436825
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String html = "<html><body><table><tr><td id=\"color\" align=\"center\">" +
                        "Z 29.02-23.05 someText," +
                        "<br>" +
                        "some.Text2 <a href=\"man.php?id=111\">J. Smith</a> (l.)&nbsp;" +
                        "</td></tr></table></body></html>";
        Document doc = Jsoup.parse( html );
        Element td = doc.getElementById( "color" );
        String text = getText( td );
        System.out.println("Text: " + text);
    }

    /**
     * Get the custom text from the given {@link Element}.
     * @param element The {@link Element} from which get the custom text.
     * @return Returns the custom text.
     */
    private static String getText(Element element) {
        String working = "";
        List<Node> childNodes = element.childNodes();
        boolean brFound = false;
        for (int i = 0; i < childNodes.size(); i++) {
            Node child = childNodes.get( i );
             if (child instanceof TextNode) {
                 if(brFound){
                     working += ((TextNode) child).text();
                 }
             }
             if (child instanceof Element) {
                 Element childElement = (Element)child;
                 if(brFound){
                     working += childElement.text();
                 }
                 if(childElement.tagName().equals( "br" )){
                     brFound = true;
                 }
             }
        }
        return working;
    }
}