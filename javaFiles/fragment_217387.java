import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Marshall {

    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Configuration.class);
        Marshaller marshaller = context.createMarshaller();
        Configuration config = new Configuration();
        List<String> list = config.getComponent();
        list.add("Hello");
        list.add("World");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(config, System.out);
    }
}