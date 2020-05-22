@XmlRootElement(name = "Foo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Foo implements Serializable {
    private static final long serialVersionUID = 1L;

    public Foo() {}

    // wrap your map in a table tag
    @XmlElementWrapper(name = "table")
    // the entry will be the tag used to enclose the key,value pairs
    @XmlElement(name="entry")
    Map<Object, Object> myMap = new HashMap<Object, Object>();

    public Map<Object,Object> getMyMap() {
        return myMap;
    }
}