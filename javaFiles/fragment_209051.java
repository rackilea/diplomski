@XmlRootElement
public class OtherObject {
    private String flag;
    private String id;
    private String otherDescription;

    @XmlElement
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    @XmlElement
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @XmlElement
    public String getOtherDescription() {
        return otherDescription;
    }
    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }
}