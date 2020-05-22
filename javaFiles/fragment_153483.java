package forum14845035;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    @XmlElementDecl(name="root1")
    public JAXBElement<SameType> createRoot1(SameType sameType) {
        return new JAXBElement<SameType>(new QName("urn:example", "root1"), SameType.class, sameType);
    }

    @XmlElementDecl(name="root2")
    public JAXBElement<SameType> createRoot2(SameType sameType) {
        return new JAXBElement<SameType>(new QName("urn:example", "root2"), SameType.class, sameType);
    }

}