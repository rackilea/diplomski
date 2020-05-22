import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(MailAccount.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum20699078/input.xml");
        MailAccount mailAccount = (MailAccount) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(MailAccountService.class.getResource("/emailAddresses.xsd"));
        marshaller.setSchema(schema);

        marshaller.marshal(mailAccount, System.out);
    }

}