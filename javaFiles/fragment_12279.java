import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Link {

    @XmlAttribute
    private String rel;

    @XmlAttribute
    private String href;

    @XmlAttribute
    private String type;

}