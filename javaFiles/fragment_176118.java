package forum7177628;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Persons.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Persons persons = (Persons) unmarshaller.unmarshal(new File("src/forum7177628/input.xml"));

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(persons, System.out);
    }

}