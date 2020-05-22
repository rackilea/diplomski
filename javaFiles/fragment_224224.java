import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(AnimalList.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("input.xml");
        AnimalList animalList = (AnimalList) unmarshaller.unmarshal(xml);

        for(Animal animal : animalList.getEntries()) {
            System.out.println(animal.getClass());
        }

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(animalList, System.out);
    }

}