import java.io.File;
import java.util.*;

import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.dynamic.DynamicEntity;
import org.eclipse.persistence.jaxb.JAXBHelper;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContextFactory;

public class Demo {

    public static void main(String[] args) throws Exception {
        StreamSource schemaSource = new StreamSource("src/forum20146935/schema.xsd");
        Map<String, Object> properties = new HashMap<String, Object>(1);
        properties.put(DynamicJAXBContextFactory.EXTERNAL_BINDINGS_KEY, new StreamSource("src/forum20146935/binding.xml"));
        JAXBContext jc = DynamicJAXBContextFactory.createContextFromXSD(schemaSource, null, Demo.class.getClassLoader(), properties);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum20146935/input.xml");
        DynamicEntity root = (DynamicEntity) unmarshaller.unmarshal(xml);

        String fooBar = JAXBHelper.getJAXBContext(jc).getValueByXPath(root, "foo_bar/text()", null, String.class);
        System.out.println(fooBar);
    }

}