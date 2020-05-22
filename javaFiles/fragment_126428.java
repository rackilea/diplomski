import java.util.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.jaxb.MarshallerProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(2);
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
        JAXBContext jc = JAXBContext.newInstance(new Class[] {ClassA.class}, properties);

        ClassA classA = new ClassA();
        classA.objectId = 1;
        classA.property1 = "value1";

        classA.status = "new";
        marshal(jc, classA);

        classA.status = "deleted";
        marshal(jc, classA);
    }

    private static void marshal(JAXBContext jc, ClassA classA) throws Exception {
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        if("deleted".equals(classA.status)) {
            marshaller.setProperty(MarshallerProperties.OBJECT_GRAPH, "deleted");
        }
        marshaller.marshal(classA, System.out);
    }

}