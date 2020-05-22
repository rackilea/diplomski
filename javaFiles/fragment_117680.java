import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.MarshallerProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Policy.class);

        Person person = new Person();
        person.setClientId(1234);
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setEmail("jdoe@example.com");

        Policy policy = new Policy();
        policy.setClient(person);
        policy.setUserCreated(person);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(MarshallerProperties.OBJECT_GRAPH, "policy");
        marshaller.marshal(policy, System.out);
    }

}