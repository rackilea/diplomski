@XmlRootElement(name = "ROOT")
public class DocumentList {

    @XmlElement(name="DOCUMENT")
    private List documents;

    @XmlElement(name="TEXT")
    private List texts;

    @XmlElement(name="ITEMS")
    private List items;

}