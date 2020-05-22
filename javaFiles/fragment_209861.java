@javax.persistence.Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Element {
    @Id
    @GeneratedValue
    @Column(name = "element_id")
    private Long id;
    @Column(name = "uuid", nullable = false)
    private String uuid;
    @Column(name = "value")
    private String value;

    public Element(String value) {
        this.value = value;
    }

    public Element() {

    }

    @PrePersist
    public void initUuid() {
        this.uuid = UUID.randomUUID().toString();
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
}