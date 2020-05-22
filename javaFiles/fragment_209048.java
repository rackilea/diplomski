@XmlRootElement
public class SomeList {
    private List<SomeObject> someObject;

    @XmlElement
    public List<SomeObject> getSomeObject() {
        return someObject;
    }
    public void setSomeObject(List<SomeObject> someObject) {
        this.someObject = someObject;
    }
}