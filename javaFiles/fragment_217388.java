@XmlRootElement(name = "Configuration")
public class Configuration {

    @XmlElement
    protected List<String> component;

    public List<String> getComponent() {
        if (component == null) {
            component = new ArrayList<String>();
        }
        return this.component;
    }
}