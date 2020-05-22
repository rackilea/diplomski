@XmlRootElement(name = DisplayType.DISPLAY_TYPE)
@XmlAccessorType(XmlAccessType.NONE)
public class DisplayType {

    static final String DISPLAY_TYPE = "display-type";
    private static final String DEFAULT = "default";


    @XmlAttribute(name = DEFAULT)
    private Boolean defaultName;


    @XmlValue
    private String name;
}