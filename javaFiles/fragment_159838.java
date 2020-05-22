package forum11334385;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(B.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum11334385/input.xml");
        B b = (B) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(b, System.out);
    }

}