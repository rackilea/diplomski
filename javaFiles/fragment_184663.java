import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    @XmlElementDecl(name="InvoiceAdd")
    JAXBElement<TransactionAdd> createInvoiceAdd(TransactionAdd invoiceAdd) {
        return new JAXBElement<TransactionAdd>(new QName("InvoiceAdd"), TransactionAdd.class, invoiceAdd);
    }

    @XmlElementDecl(name="SalesOrderAdd")
    JAXBElement<TransactionAdd> createSalesOrderAdd(TransactionAdd salesOrderAdd) {
        return new JAXBElement<TransactionAdd>(new QName("SalesOrderAdd"), TransactionAdd.class, salesOrderAdd);
    }

}