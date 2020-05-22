package forum13941747;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Payload.class, Foo.class, ObjectFactory.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum13941747/input.xml");
        Payload payload = (Payload) unmarshaller.unmarshal(xml);

        for(Object o : payload.any) {
            System.out.println(o.getClass());
        }

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(payload, System.out);
    }

}