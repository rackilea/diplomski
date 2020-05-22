package forum12990635;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllServicesPartnersRequest_QNAME = new QName("", "get-all-services-partners-request");

    public ObjectFactory() {
    }

    public Foo createFoo() {
        return new Foo();
    }

    @XmlElementDecl(namespace = "", name = "get-all-services-partners-request")
    public JAXBElement<Object> createGetAllServicesPartnersRequest(Object value) {
        return new JAXBElement<Object>(_GetAllServicesPartnersRequest_QNAME, Object.class, null, value);
    }

}