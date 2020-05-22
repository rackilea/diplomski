package forum13941747;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    @XmlElementDecl(name="bar")
    public JAXBElement<Bar> createBar(Bar bar) {
        return new JAXBElement<Bar>(new QName("bar"), Bar.class, bar);
    }

}