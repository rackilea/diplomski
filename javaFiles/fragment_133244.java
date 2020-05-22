package nov18;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(FosterHome.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        FosterHome fosterHome = (FosterHome) unmarshaller.unmarshal(new File("src/nov18/input.xml"));

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(fosterHome, System.out);
    }

}