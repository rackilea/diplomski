import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Thing.class);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Thing thing = new Thing();
        thing.setName("popcorn ball");

        thing.setAwesome(false);
        marshaller.marshal(thing, System.out);

        thing.setAwesome(true);
        marshaller.marshal(thing, System.out);
    }

}