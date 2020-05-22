import javax.xml.bind.*;
import javax.xml.datatype.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);

        DatatypeFactory df = DatatypeFactory.newInstance();
        XMLGregorianCalendar date  = df.newXMLGregorianCalendar("2013-07-03");
        XMLGregorianCalendar dateTime = df.newXMLGregorianCalendar("1999-12-31T23:59:00");

        Root root = new Root();
        root.default1 = date;
        root.default2 = dateTime;
        root.schemaTypeDate = dateTime;

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(root, System.out);
    }

}