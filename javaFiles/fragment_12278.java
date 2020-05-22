import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Link {

    @XmlAttribute(namespace="http://www.w3.org/2005/Atom")
    private String rel;

    @XmlAttribute(namespace="http://www.w3.org/2005/Atom")
    private String href;

    @XmlAttribute(namespace="http://www.w3.org/2005/Atom")
    private String type;

}