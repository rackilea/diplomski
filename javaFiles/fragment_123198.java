package forum15821738;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Person.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum15821738/input.xml");
        Person person = (Person) unmarshaller.unmarshal(xml);

        for(Person child : person.getChildren()) {
            System.out.println(child.getParent());
        }

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(person, System.out);
    }

}