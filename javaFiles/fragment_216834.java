import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;

/* Other code here */

private HashSet<String> parseFile()
        throws ProcessingException
{
    String fileLocation = getInterfaceLocation();
    HashSet<String> fileMasks = new HashSet<>();

    File file = new File(fileLocation);

    try {
        // BEGIN: DOM Boilerplate
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        // END: DOM Boilerplate

        Document doc = builder.parse(file);

        XPathExpression includeQuery = xpath.compile("//include[@name]");
        NodeList includes = (NodeList) includeQuery.evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < includes.getLength(); i++) {
            Element include = (Element) includes.item(i);
            fileMasks.add(include.getAttribute("name"));
        }
    } catch (Exception e) {
        throw new ProcessingException("Failed to parse file", e);
    }

    return fileMasks;
}