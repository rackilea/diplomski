import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbApp {

    public static void main(String[] args) throws Exception {
        File xmlFile = new File("./resource/test.xml").getAbsoluteFile();

        JAXBContext context = JAXBContext.newInstance(Root.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        JAXBElement<Root> root = (JAXBElement<Root>) unmarshaller.unmarshal(xmlFile);
        System.out.println(root.getValue());

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(root, System.out);
    }
}