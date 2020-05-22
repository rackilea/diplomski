import javax.xml.bind.annotation.*;

@XmlRootElement(name="outline")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutlineItem implements java.io.Serializable {

    private static final long serialVersionUID = -2321669186524783800L;

    @XmlAttribute
    private String text;

    @XmlElement("outline")
    private List<OutlineItem> childItems;

}