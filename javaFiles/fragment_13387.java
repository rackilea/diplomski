package forum12713373;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    @XmlElementDecl(name="absent")
    public JAXBElement<Boolean> createAbsent(Boolean value) {
        return new JAXBElement(new QName("absent"), Boolean.class, value);
    }

    @XmlElementDecl(name="setToNull")
    public JAXBElement<Boolean> createSetToNull(Boolean value) {
        return new JAXBElement(new QName("setToNull"), Boolean.class, value);
    }

    @XmlElementDecl(name="setToValue")
    public JAXBElement<Boolean> createSetToValue(Boolean value) {
        return new JAXBElement(new QName("setToValue"), Boolean.class, value);
    }

}