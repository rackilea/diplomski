import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@XmlRootElement
class MapExample {
  @XmlJavaTypeAdapter(MapXmlAdapter.class)
  @XmlElement(name="map")
  private Map<String, String> data = new HashMap<>();

  public static void main(String[] args) throws Exception {
    MapExample example = new MapExample();
    example.data.put("France", "Paris");
    example.data.put("Japan", "Tokyo");

    JAXBContext context = JAXBContext.newInstance(MapExample.class);
    Marshaller marshaller = context.createMarshaller();
    DOMResult result = new DOMResult();
    marshaller.marshal(example, result);

    XPathFactory factory = XPathFactory.newInstance();
    XPath xpath = factory.newXPath();

    Document document = (Document)result.getNode();
    XPathExpression expression = xpath.compile("//map/entry");
    NodeList nodes = (NodeList)expression.evaluate(document, XPathConstants.NODESET);

    expression = xpath.compile("//map");
    Node oldMap = (Node)expression.evaluate(document, XPathConstants.NODE);    
    Element newMap = document.createElement("map");

    for (int index = 0; index < nodes.getLength(); index++) {
      Element element = (Element)nodes.item(index);
      newMap.setAttribute(element.getAttribute("key"), 
          element.getAttribute("value"));
    }

    expression = xpath.compile("//map/..");
    Node parent = (Node)expression.evaluate(document, XPathConstants.NODE);    
    parent.replaceChild(newMap, oldMap);

    TransformerFactory.newInstance().newTransformer().
      transform(new DOMSource(document), new StreamResult(System.out));
  }
}

class MapXmlAdapter extends XmlAdapter<MyMap, Map<String, String>> {
  @Override
  public Map<String, String> unmarshal(MyMap value) throws Exception {
    throw new UnsupportedOperationException();
  }

  @Override
  public MyMap marshal(Map<String, String> value) throws Exception {
    MyMap map = new MyMap();
    map.entries = new ArrayList<MyEntry>();
    for (String key : value.keySet()) {
      MyEntry entry = new MyEntry();
      entry.key = key;
      entry.value = value.get(key);
      map.entries.add(entry);
    }
    return map;
  }
}

class MyMap {
  @XmlElement(name="entry")
  public List<MyEntry> entries;
}

class MyEntry {
  @XmlAttribute
  public String key;

  @XmlAttribute
  public String value;
}