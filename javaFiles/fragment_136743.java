@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ROW")
public class Row {

    @XmlAttribute
    private int id;
    @XmlElement(name = "MOBILE")
    private int mobileNo;

    @XmlMixed
    @XmlAnyElement
    @XmlJavaTypeAdapter(MyMapAdapter.class)
    private Map<String, String> otherElements;
}