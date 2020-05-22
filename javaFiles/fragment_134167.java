package forum13404583;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Graph.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum13404583/input.xml");
        Graph graph = (Graph) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(graph, System.out);
    }

}