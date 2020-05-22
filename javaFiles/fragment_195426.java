import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

public class TestXpath
{

    public static void main(String[] args) {

        XPath xPath = XPathFactory.newInstance().newXPath();

        try (InputStream is = Files.newInputStream(Paths.get("C://temp/test.xml"))) {
            // parse file into xml doc
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlDocument = builder.parse(is);

            // find all element names in xml doc
            Set<String> allElementNames = findNames(xmlDocument, xPath.compile("//*[name()]"));
            // for each name, count occurrences, and collect to map
            Map<String, Integer> elementsAndOccurrences = allElementNames.stream()
                .collect(Collectors.toMap(Function.identity(), name -> countElementOccurrences(xmlDocument, name)));
            System.out.println(elementsAndOccurrences);

            // find all attribute names in xml doc
            Set<String> allAttributeNames = findNames(xmlDocument, xPath.compile("//@*"));
            // for each name, count occurrences, and collect to map
            Map<String, Integer> attributesAndOccurrences = allAttributeNames.stream()
                .collect(Collectors.toMap(Function.identity(), name -> countAttributeOccurrences(xmlDocument, name)));
            System.out.println(attributesAndOccurrences);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Set<String> findNames(Document xmlDoc, XPathExpression xpathExpr) {
        try {
            NodeList nodeList = (NodeList)xpathExpr.evaluate(xmlDoc, XPathConstants.NODESET);
            // convert nodeList to set of node names
            return IntStream.range(0, nodeList.getLength())
                .mapToObj(i -> nodeList.item(i).getNodeName())
                .collect(Collectors.toSet());
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }

    public static int countElementOccurrences(Document xmlDoc, String elementName) {
        return countOccurrences(xmlDoc, elementName, "count(//*[name()='" + elementName + "'])");
    }

    public static int countAttributeOccurrences(Document xmlDoc, String attributeName) {
        return countOccurrences(xmlDoc, attributeName, "count(//@*[name()='" + attributeName + "'])");
    }

    public static int countOccurrences(Document xmlDoc, String name, String xpathExpr) {
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            Number count = (Number)xPath.compile(xpathExpr).evaluate(xmlDoc, XPathConstants.NUMBER);
            return count.intValue();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return 0;
    }
}