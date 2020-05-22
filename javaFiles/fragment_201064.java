package grimbo.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class StackOverflow {
    public static void main(String[] args) {
        String html = "<div class=quoted-message>message-1</div>\n    <br />\n    <br />\n    Hello quoted message\n    <br />\n    I am a response\n    <br />\n    <br />\n";
        html += "<div class=quoted-message>message-2</div>\n    <br />\n    <br />\n    Hello quoted message\n    <br />\n    I am a response\n    <br />\n    <br />\n";
        Document doc = Jsoup.parse(html);
        handleQuotedMessages(doc.select(".quoted-message"));
    }

    private static void handleQuotedMessages(Elements quotedMessages) {
        Element firstQuotedMessage = quotedMessages.first();
        List<Node> siblings = firstQuotedMessage.siblingNodes();
        List<Node> elementsBetween = new ArrayList<Node>();
        Element currentQuotedMessage = firstQuotedMessage;
        for (int i = 1; i < siblings.size(); i++) {
            Node sibling = siblings.get(i);

            // see if this Node is a quoted message
            if (!isQuotedMessage(sibling)) {
                elementsBetween.add(sibling);
            } else {
                createQuotePost(currentQuotedMessage, elementsBetween);
                currentQuotedMessage = (Element) sibling;
                elementsBetween.clear();
            }
        }
        if (!elementsBetween.isEmpty()) {
            createQuotePost(currentQuotedMessage, elementsBetween);
        }
    }

    private static boolean isQuotedMessage(Node node) {
        if (node instanceof Element) {
            Element el = (Element) node;
            return "div".equals(el.tagName()) && el.hasClass("quoted-message");
        }
        return false;
    }

    private static List<Element> filterElements(String tagName, List<Node> nodes) {
        List<Element> els = new ArrayList<Element>();
        for (Iterator<Node> it = nodes.iterator(); it.hasNext();) {
            Node n = it.next();
            if (n instanceof Element) {
                Element el = (Element) n;
                if (el.tagName().equals(tagName)) {
                    els.add(el);
                }
            }
        }
        return els;
    }

    private static void createQuotePost(Element quote, List<Node> elementsBetween) {
        System.out.println("createQuotePost: " + quote);
        System.out.println("createQuotePost: " + elementsBetween);
        List<Element> imgs = filterElements("img", elementsBetween);
        // handle imgs
    }
}