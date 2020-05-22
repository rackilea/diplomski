import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElement(defaultValue="a b c")
    String singleMissingElement;

    @XmlElement(defaultValue="a b c")
    String singleEmptyElement;

    @XmlElement(defaultValue="a b c")
    String singlePopulatedElement;

    @XmlElement(defaultValue="a b c")
    @XmlList
    List<String> listMissingElement;

    @XmlElement(defaultValue="a b c")
    @XmlList
    List<String> listEmptyElement;

    @XmlElement(defaultValue="a b c")
    @XmlList
    List<String> listPopulatedElement;

}