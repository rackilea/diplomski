import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    @XmlElementDecl(name = "a")
    public JAXBElement<Integer> createA(Integer integer) {
        return new JAXBElement<Integer>(new QName("a"), Integer.class, integer);
    }


    @XmlElementDecl(name = "b")
    public JAXBElement<Integer> createB(Integer integer) {
        return new JAXBElement<Integer>(new QName("b"), Integer.class, integer);
    }

}