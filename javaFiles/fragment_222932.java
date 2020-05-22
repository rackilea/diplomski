import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.JAXBContextFactory;

public class Demo {

    public static void main(String[] args) throws Exception {
        //JAXBContext jc = JAXBContext.newInstance(Animals.class);
        JAXBContext jc = JAXBContextFactory.createContext(new Class[] {Animals.class}, null);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum6871469/input.xml");
        Animals animals = (Animals) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(animals, System.out);
    }

}