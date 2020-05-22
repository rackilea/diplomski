@XmlRootElement
public class WrapperList<T> {

    private List<T> list;

    public WrapperList() {
        list = new ArrayList<T>();
    }

    public WrapperList(List<T> list) {
        this.list = list;
    }

    @XmlAnyElement
    public List<T> getItems() {
        return list;
    }
}