import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(PlacementRules.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        File xml = new File("src/forum38/input.xml");
        PlacementRules placementRules = (PlacementRules) unmarshaller.unmarshal(xml);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(placementRules, System.out);
    }
}