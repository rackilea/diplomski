import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;

public dumpXMLTags(...) {
  String[] keys; // you would need that with appropriate size initialized
  String[] values;  

  // Parse your XML file and construct DOM tree
  File fXmlFile = new File(PATH_TO_YOUR_XML_FILE);
  DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
  Document doc = dBuilder.parse(fXmlFile);
  doc.getDocumentElement().normalize();

  // Traverse DOM tree (make sure is not empty first, etc)
  NodeIterator iterator = traversal.createNodeIterator(
      doc.getDocumentElement(), NodeFilter.SHOW_ELEMENT, null, true);

  int i = 0;  // index to you key/value Array

  for (Node n = iterator.nextNode(); n != null; n = iterator.nextNode()) {
     keys[i] = ((Element) n).getTagName();
     values[i] = ((Element)n).getNodeValue();
     i++;
  }
}