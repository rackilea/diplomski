import org.xml.sax.InputSource;

import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

public class XPathTest {

    public static void main(String[] args) throws XPathExpressionException {

        String xml = "<channel>\n" +
                "\n" +
                "   <title>Site Name</title>\n" +
                "\n" +
                "   <item>  \n" +
                "       <title>News Title!</title>       \n" +
                "   </item>\n" +
                "\n" +
                "</channel>";

        Object result = XPathFactory.newInstance().newXPath().compile("/channel/item/title").evaluate(new InputSource(new StringReader(xml)));
        System.out.print(result);
    }
}