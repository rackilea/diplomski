@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "helloArray", propOrder = {"name"})
public class HelloArray {

    @XmlElement(nillable = true)
    protected List<String> name;

    public List<String> getName() {
        if (name == null) {
            name = new ArrayList<String>();
        }
        return this.name;
    }
}