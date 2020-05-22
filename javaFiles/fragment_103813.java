import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Element.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum17775900/input.xml");
        Element element = (Element) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(element, System.out);
    }

}