@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    @XmlElement(name = "id", namespace = "http://base.google.com/ns/1.0")
    private String id;

    @XmlElement(name = "title", namespace = "http://base.google.com/ns/1.0")
    private String title;

    @XmlElement(name = "sport", namespace = "http://base.google.com/ns/1.0")
    private String sport;

    // public getters and setters (omitted here for brevity)
}