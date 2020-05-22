@XmlRootElement(name = "root")
public class ExampleRootElement {
    private int version;
    private ExampleBaseSubElement subElement;

    @XmlAttribute(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlElementRef // here!
    public ExampleBaseSubElement getSubElement() {
        return subElement;
    }

    public void setSubElement(ExampleBaseSubElement subElement) {
        this.subElement = subElement;
    }
}