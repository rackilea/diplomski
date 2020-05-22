@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "component"
})
@XmlRootElement(name = "Configuration")
public class Configuration {

    protected List<String> component;

    public List<String> getComponent() {
        if (component == null) {
            component = new ArrayList<String>();
        }
        return this.component;
    }
}