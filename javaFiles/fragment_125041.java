import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

public class JaxbApp {

    public static void main(String[] args) throws Exception {
        File xmlFile = new File("./resource/test.xml").getAbsoluteFile();

        JAXBContext jaxbContext = JAXBContext.newInstance(Net.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object net = unmarshaller.unmarshal(xmlFile);
        System.out.println(net);
    }
}