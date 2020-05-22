@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorMeta {

    @XmlElement(name="link", namespace="http://www.w3.org/2005/atom")
    private Atomlink link;

    public Atomlink getLink() {
        return link;
    }

    public void setLink(Atomlink link) {
        this.link = link;
    }
}