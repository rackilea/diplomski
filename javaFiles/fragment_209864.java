@javax.persistence.Entity
public class Information {

    @Id
    @GeneratedValue
    @Column(name = "information_id")
    private Long id;
    private String uuid;
    private String value;
    private String innerText;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH} )
    private List<Element> elements;

    public Information() {

    }

    public Information(String innerText, List<Element> elements) {
        this.innerText = innerText;
        this.elements = elements;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getInnerText() {
        return innerText;
    }

    public void setInnerText(String innerText) {
        this.innerText = innerText;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}