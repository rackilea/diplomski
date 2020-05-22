import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Clazz.class, ObjectFactory.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum22502171/input.xml");
        Clazz clazz = (Clazz) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(clazz, System.out);
    }

}