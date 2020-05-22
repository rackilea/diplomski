import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(TransactionAdd.class, ObjectFactory.class);

        File xml = new File("src/forum107/input1.xml");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<TransactionAdd> je = (JAXBElement<TransactionAdd>) unmarshaller.unmarshal(xml);
        TransactionAdd ta = je.getValue();
        ta.setTxnType(je.getName().getLocalPart());

        JAXBElement<TransactionAdd> jeOut;
        if("InvoiceAdd".equals(ta.getTxnType())) {
            jeOut = new ObjectFactory().createInvoiceAdd(ta);
        } else {
            jeOut = new ObjectFactory().createSalesOrderAdd(ta);
        }
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(jeOut, System.out);
    }

}