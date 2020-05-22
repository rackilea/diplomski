import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Element {

    @XmlAttribute
    private String attribute1;

    @XmlAttribute
    private String attribute2;

    @XmlAttribute
    private String attribute3;

    @XmlValue
    private List<String> value;

}