@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Feed {

    @XmlElement(name="schema-version", namespace = "http://www.example.com/publications/api")
    private String schemaVersion;
    @XmlElement
    private String category;
    @XmlElement
    private String id;

    @XmlElement(name="entry")
    private Entry entry;

}