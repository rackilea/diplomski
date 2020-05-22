@XmlRootElement
public class SampleDTO {
    private String id;
    private List<SomeList> someList;
    private List<OtherList> otherList;

    @XmlElement
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @XmlElement
    public List<SomeList> getSomeList() {
        return someList;
    }
    public void setSomeList(List<SomeList> someList) {
        this.someList = someList;
    }
    @XmlElement
    public List<OtherList> getOtherList() {
        return otherList;
    }
    public void setOtherList(List<OtherList> otherList) {
        this.otherList = otherList;
    }
}