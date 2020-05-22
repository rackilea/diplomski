import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

...

final String xml = "<node id=\"101\"><node id=\"102\"><node id=\"103\" /></node><node id=\"104\"><node id=\"103\" /></node></node>";
final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
final DocumentBuilder db = dbf.newDocumentBuilder();
final Document doc = db.parse(new InputSource(new StringReader(xml)));
final XPathFactory xpathFactory = XPathFactory.newInstance();
final XPath xpath = xpathFactory.newXPath();
final NodeList nodes = (NodeList) xpath.compile("//node[@id]").evaluate(doc, XPathConstants.NODESET);
for (int nodeNumber = 0; nodeNumber < nodes.getLength(); ++nodeNumber) {
    final Element node = (Element) nodes.item(nodeNumber);
    final String nodeId = node.getAttribute("id");
    final String newNodeId = "prefix/" + nodeId;
    node.getAttributeNode("id").setValue(newNodeId);
}