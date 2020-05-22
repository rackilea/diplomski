package forum9931520;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Kml.class);

        File xml = new File("src/forum9931520/input.xml");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Kml kml = (Kml) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(kml, System.out);
    }

}