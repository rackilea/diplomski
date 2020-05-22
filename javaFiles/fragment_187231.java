@XmlRootElement
public class Case {

    private int version;
    private String code;
    private String id;
    private Meta meta;

    public int getVersion() {
        return version;
    }

    @XmlElement
    public void setVersion(int version) {
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    @XmlElement
    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    @XmlElement
    public void setId(String id) {
        this.id = id;
    }

    public Meta getMeta() {
        return meta;
    }

    @XmlElement
    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}