import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(1);
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, "forum19641824/oxm.xml");
        JAXBContext jc = JAXBContext.newInstance(new Class[] {Customer.class}, properties);

        Customer customer = new Customer();
        customer.setFirstname("Tony");
        customer.setLastname("Stark");

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setAdapter(new LastNameAdapter("01.01.1990"));
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customer, System.out);
    }

}