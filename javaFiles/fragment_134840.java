package forum13159089;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Transition.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum13159089/input.xml");
        Transition transition = (Transition) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(transition, System.out);
    }

}