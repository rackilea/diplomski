import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JaxbApp {

    public static void main(String[] args) throws Exception {
        File xmlFile = new File("./resource/test.xml").getAbsoluteFile();

        JAXBContext context = JAXBContext.newInstance(Root.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Root root = (Root) unmarshaller.unmarshal(xmlFile);

        System.out.println(root);
    }
}

@XmlRootElement(name = "root")
class Root {

    private List<Item> items = new ArrayList<>();

    @XmlElement(name = "object")
    public List<Item> getItems() {
        return items;
    }

    // getters, setters, toString
}

@XmlJavaTypeAdapter(ItemXmlAdapter.class)
class Item {

    private Map<String, String> properties;

    // getters, setters, toString
}