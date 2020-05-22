import java.io.*;
import javax.xml.stream.*;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception  {
        XMLInputFactory xif = XMLInputFactory.newInstance();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("input.xml"));
        xsr.nextTag(); // Advance to statements element

        JAXBContext jc = JAXBContext.newInstance(Person.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        while(xsr.nextTag() == XMLStreamConstants.START_ELEMENT) {
            Person person = (Person) unmarshaller.unmarshal(xsr);
        }
    }

}