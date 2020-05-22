@XmlRootElement
public class OtherList {
    private List<OtherObject> otherObject;

    @XmlElement
    public List<OtherObject> getOtherObject() {
        return otherObject;
    }
    public void setOtherObject(List<OtherObject> otherObject) {
        this.otherObject = otherObject;
    }
}