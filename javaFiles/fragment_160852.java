import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class XMLParser
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        try {

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        InputSource doc = new InputSource(new InputStreamReader(new FileInputStream(new File("file.xml"))));

        String expression = "//Home/ListOfCustomers";
        XPathExpression xPathExpression = xPath.compile(expression);

        NodeList elem1List = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        xPathExpression = xPath.compile("@type");

        for (int i = 0; i < elem1List.getLength(); i++)
        {
            System.out.println(xPathExpression.evaluate(elem1List.item(i), XPathConstants.STRING)); 
        }


        }
        catch (XPathExpressionException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}