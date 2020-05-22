import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbApp {

    public static void main(String[] args) throws Exception {
        File xmlFile = new File("./resource/test.xml").getAbsoluteFile();

        JAXBContext context = JAXBContext.newInstance(Items.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Items root = (Items) unmarshaller.unmarshal(xmlFile);

        System.out.println(root);
    }
}

class ItemXmlAdapter extends XmlAdapter<Object, Item> {

    @Override
    public Item unmarshal(Object v) {
        Element element = (Element) v;
        Node dependencies = element.getFirstChild();
        List<String> ids = new ArrayList<>();
        if (dependencies != null) {
            NodeList childNodes = dependencies.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                NamedNodeMap attributes = item.getAttributes();
                if (attributes != null) {
                    Node id = attributes.getNamedItem("id");
                    if (id != null) {
                        ids.add(id.getNodeValue());
                    }
                }
            }
        }

        Item item = new Item();
        item.setId(element.getAttribute("id"));
        item.setDependencyIds(ids);

        return item;
    }

    @Override
    public Object marshal(Item v) throws Exception {
        return null; // Implement if needed
    }
}

@XmlRootElement(name = "items")
class Items {

    private List<Item> items = new ArrayList<>();

    @XmlElement(name = "item")
    public List<Item> getItems() {
        return items;
    }
}

@XmlJavaTypeAdapter(ItemXmlAdapter.class)
class Item {

    private String id;
    private List<String> dependencyIds;
    private List<Item> dependencies;

    // getters, setters
}