import java.io.FileOutputStream;
import java.util.*;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Element.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

        List<Element> elements = new ArrayList<>();
        elements.add(new Element());
        elements.add(new Element());

        try(FileOutputStream fos = new FileOutputStream("src/forum18509018/out.txt")) {
           for(Element element : elements) {
               marshaller.marshal(element, fos);
           }
        }
    }

}