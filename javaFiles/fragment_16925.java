@XmlRootElement(name = "Element")
@XmlAccessorType(XmlAccessType.FIELD)
public class Element {

    @XmlElementWrapper(name = "fooList")
    @XmlElements({
            @XmlElement(name = "id", type = Id.class),
            @XmlElement(name = "code", type = Code.class),
    })
    private List<FooItem> foos;

    public List<FooItem> getfoos() {
        return foos;
    }
    public void setFoos(List<FooItem> foos) {
        this.foos = foos;
    }
}