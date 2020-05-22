import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashMap;
import java.util.Map;

public class MyMapAdapter extends XmlAdapter<Element, Map<String, String>> {

    private Map<String, String> hashMap = new HashMap<>();

    @Override
    public Element marshal(Map<String, String> map) throws Exception {
        // expensive, but keeps the example simpler
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        Element root = document.createElement("dynamic-elements");

        for(Map.Entry<String, String> entry : map.entrySet()) {
            Element element = document.createElement(entry.getKey());
            element.setTextContent(entry.getValue());
            root.appendChild(element);

        }

        return root;
    }


    @Override
    public Map<String, String> unmarshal(Element element) {
        String tagName = element.getTagName();
        String elementValue = element.getChildNodes().item(0).getNodeValue();
        hashMap.put(tagName, elementValue);

        return hashMap;
    }
}