import java.io.Serializable;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Clazz implements Serializable {

    @XmlElementRefs({
        @XmlElementRef(name="a", type=JAXBElement.class),
        @XmlElementRef(name="b", type=JAXBElement.class)
    })
    private JAXBElement<Integer> aOrB;

}