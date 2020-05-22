@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {


    @XmlElement
    private String id;
    @XmlElement
    private String category;
    @XmlElement
    private String content;

    @XmlElement(name="object", namespace = "http://www.example.com/publications/api")
    private ApiObject object;

}