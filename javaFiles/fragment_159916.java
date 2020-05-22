package forum10075634;

import java.io.StringReader;
import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextFactory;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(1);
        properties.put(JAXBContextFactory.ECLIPSELINK_OXM_XML_KEY, "forum10075634/bindings.xml");
        JAXBContext jc = JAXBContext.newInstance(new Class[] {SampleClassA.class}, properties);

        StringReader xml = new StringReader("<SAMPLE SomeProperty='Foo'/>");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        SampleClassA sampleClassA = (SampleClassA) unmarshaller.unmarshal(xml);

        System.out.println(sampleClassA.getSomeProperty());
        System.out.println(sampleClassA.get("somevalue"));

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(sampleClassA, System.out);
    }

}