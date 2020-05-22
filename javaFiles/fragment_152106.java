@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {


    @XmlAnyElement(lax = true)
    private List<Object> anything;

    @XmlElement(name="object", namespace = "http://www.example.com/publications/api")
    private ApiObject object;

}