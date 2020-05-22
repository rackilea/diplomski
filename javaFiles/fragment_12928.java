@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "artist")
public class Artist {

    @XmlElementRef(name = "name", type = JAXBElement.class, required = false)
    @XmlMixed
    protected List<Serializable> content;

    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }
}

@XmlRegistry
public class ObjectFactory {

    private final static QName NAME_QNAME = new QName("", "name");
    public ObjectFactory() {}

    public Artist createArtist() {
        return new Artist();
    }

    @XmlElementDecl(namespace = "", name = "name", scope = Artist.class)
    public JAXBElement<String> createArtistName(String value) {
        return new JAXBElement<String>(NAME_QNAME, String.class, Artist.class, value);
    }
}