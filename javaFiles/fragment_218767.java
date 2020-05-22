import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(SummaryCart.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum15881876/input.xml");
        SummaryCart sc = (SummaryCart) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "SummaryCart.xsd");
        marshaller.marshal(sc, System.out);
    }

}