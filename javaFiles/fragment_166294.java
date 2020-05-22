import java.io.File;
import javax.xml.bind.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class BinderDemo {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        File xml = new File("input.xml");
        Document document = db.parse(xml);

        JAXBContext jc = JAXBContext.newInstance(Customer.class);

        Binder<Node> binder = jc.createBinder();
        Customer customer = (Customer) binder.unmarshal(document);
        customer.getAddress().setStreet("2 NEW STREET");
        PhoneNumber workPhone = new PhoneNumber();
        workPhone.setType("work");
        workPhone.setValue("555-WORK");
        customer.getPhoneNumbers().add(workPhone);
        binder.updateXML(customer);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.transform(new DOMSource(document), new StreamResult(System.out));
    }     
}