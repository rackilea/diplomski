@XmlRootElement(namespace = "http://www.w3.org/2005/Atom")
@XmlAccessorType(XmlAccessType.FIELD)
public class Feed {

    @XmlAnyElement(lax = true)
    private List<Object> anything;

    @XmlElement(name="entry", namespace = "http://www.w3.org/2005/Atom")
    private Entry entry;


}