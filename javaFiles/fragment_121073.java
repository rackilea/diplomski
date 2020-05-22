package forum10208143;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(User.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum10208143/input.xml");
        User user = (User) unmarshaller.unmarshal(xml);

        System.out.println(user.getPassword());

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(user, System.out);
    }

}