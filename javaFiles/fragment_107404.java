package forum20745762;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(SmMessageSet.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum20745762/input.xml");
        SmMessageSet smMessageSet = (SmMessageSet) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(smMessageSet, System.out);
    }

}