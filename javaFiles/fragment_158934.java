import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Network.class, NetworkInputs.class);

        File networkXML = new File("Network.xml");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Network network = (Network) unmarshaller.unmarshal(networkXML);

        File networkInputsXML = new File("NetworkInputs.xml");
        Unmarshaller unmarshaller2 = jc.createUnmarshaller();
        NodeAdapter nodeAdapter = new NodeAdapter();
        for(Node node : network.getNodes()) {
            nodeAdapter.getNodes().put(node.getId(), node);
        }
        unmarshaller2.setAdapter(nodeAdapter);
        NetworkInputs networkInputs = (NetworkInputs) unmarshaller2.unmarshal(networkInputsXML);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(networkInputs, System.out);
    }
}