package forum14945664;

import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.jaxb.JAXBHelper;

public class Demo {

    public static void main(String[] args) throws Exception {
        ExampleMetadataSource metadata = new ExampleMetadataSource();

        Map<String, Object> properties = new HashMap<String, Object>(1);
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, metadata);
        JAXBContext jc = JAXBContext.newInstance(new Class[] {Foo.class}, properties);

        Foo foo = new Foo();
        foo.setXInA("Hello World");

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(foo, System.out);

        metadata.setXmlTransient(Foo.class, "XInA");
        JAXBHelper.getJAXBContext(jc).refreshMetadata();
        marshaller.marshal(foo, System.out);
    }

}