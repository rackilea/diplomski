package forum12713373;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Foo {

    @XmlElementRef(name="absent")
    JAXBElement<Boolean> absent;

    @XmlElementRef(name="setToNull")
    JAXBElement<Boolean> setToNull;

    @XmlElementRef(name="setToValue")
    JAXBElement<Boolean> setToValue;

}