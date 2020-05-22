import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

...

DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
Document document = documentBuilder.parse(new File("input.xml"));

NodeList sessionNodelist = document.getElementsByTagName("session");
if(sessionNodelist.getLength() > 0) {
    Element sessionElement = (Element) sessionNodelist.item(0);
    String timeout = sessionElement.getAttribute("timeout");
    String warning = sessionElement.getAttribute("warning");
    ...
}