package forum11966714;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Demo {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Bar.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File xml = new File("src/forum11966714/input.xml");
            Bar bar = (Bar) jaxbUnmarshaller.unmarshal(xml);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(bar, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}