package forum10514244;

import java.io.File;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Personinfo.class);

        File xml = new File("src/forum10514244/input.xml");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<Personinfo> je = unmarshaller.unmarshal(new StreamSource(xml), Personinfo.class);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(je, System.out);
    }

}