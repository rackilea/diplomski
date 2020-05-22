import java.io.StringReader;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Type.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StringReader xml = new StringReader(
                "<type xml:lang='ru' xmlns:type='string'>Some text</type>");
        Type type = (Type) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(type, System.out);
    }

}