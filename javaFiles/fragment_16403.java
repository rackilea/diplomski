package forum11599191;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Customer.class);

        // Unmarshal from XML
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum11599191/input.xml");
        Customer customer = (Customer) unmarshaller.unmarshal(xml);

        // Marshal to JSON
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("eclipselink.media-type", "application/json");
        marshaller.marshal(customer, System.out);
    }

}