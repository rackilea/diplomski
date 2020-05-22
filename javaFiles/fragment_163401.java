import java.util.*;    
import javax.xml.xpath.*;    
import org.w3c.dom.*;

public class CDataFixer
{
    private final XmlHelper xml = XmlHelper.getInstance();

    public Document fix(Document document, String nodesToFix, Set<String> excludes) throws XPathExpressionException, XmlException
    {
        return fix(document, xml.newXPath().compile(nodesToFix), excludes);
    }

    private Document fix(Document document, XPathExpression nodesToFix, Set<String> excludes) throws XPathExpressionException, XmlException
    {
        Document wc = xml.copy(document); 

        NodeList nodes = (NodeList) nodesToFix.evaluate(wc, XPathConstants.NODESET);
        int nodeCount = nodes.getLength();

        for(int n=0; n<nodeCount; n++)
            parse(nodes.item(n), excludes);

        return wc;
    }

    private void parse(Node node, Set<String> excludes) throws XmlException
    {
        String text = node.getTextContent();

        for(String exclude : excludes)
        {
            String regex = String.format("(?s)(<%1$s\\b[^>]*>)(.*?)(</%1$s>)", Pattern.quote(exclude));
            text = text.replaceAll(regex, "$1<![CDATA[$2]]>$3");
        }

        String randomNode = "tmp_"+UUID.randomUUID().toString();

        text = String.format("<%1$s>%2$s</%1$s>", randomNode, text);

        NodeList parsed = xml
            .parse(text)
            .getFirstChild()
            .getChildNodes();

        node.setTextContent(null);
        for(int n=0; n<parsed.getLength(); n++)
            node.appendChild(node.getOwnerDocument().importNode(parsed.item(n), true));
    }
}