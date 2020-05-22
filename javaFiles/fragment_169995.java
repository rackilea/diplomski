import java.util.*;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
        JAXBContext jc = JAXBContext.newInstance(new Class[] {Zoo.class}, properties);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StreamSource json = new StreamSource("src/forum14210676/input.json");
        Zoo zoo = unmarshaller.unmarshal(json, Zoo.class).getValue();

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(zoo, System.out);
    }

}