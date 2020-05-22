import java.io.StringReader;
import javax.xml.xpath.*;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ReadElementsFromHtmlUsingXPath {
    private static final String html=
"<html>Read more about XPath <a href=\"www.w3schools.com/xsl/xpath_intro.asp\">here</a>..."+
"<select attr=\"other stuff\" name=\"quantity\">"+
    "<option value=\"1\" />"+
    "<option value=\"2\" selected=\"selected\" />"+
"</select>"+
"<i><b>Oh and here's the second element</b></i>"+
"<select name=\"quantity\" attr=\"other stuff\">"+
    "<option selected=\"selected\" value=\"5\" />"+
    "<option value=\"6\" />"+
"</select>"+
"And that's all folks</html>";

    private static final String xpathExpr = 
"//select[@name=\"quantity\"]/option[@selected=\"selected\"]/@value";

    public static void main(String[] args) {
        try {
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression expr = xpath.compile(xpathExpr);
            NodeList nodeList = (NodeList) expr.evaluate(new InputSource(new StringReader(html)),XPathConstants.NODESET);
            for( int i = 0; i != nodeList.getLength(); ++i )
                System.out.println(nodeList.item(i).getNodeValue());
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}