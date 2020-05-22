@XmlRootElement
public class Root {

    @XmlElementWrapper(name="parent")
    @XmlElement(name="child")
    private List<String> children;

}