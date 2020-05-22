@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceDefinition {

    @XmlAttribute
    private String key;

    @XmlJavaTypeAdapter(XmlStringMapAdapter.class)
    private Map<String, String> map = new HashMap<String, String>();

    // getters & setters
}