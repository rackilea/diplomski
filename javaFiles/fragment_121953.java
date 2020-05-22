@ManagedBean
@SessionScoped
public class SomeBean {

    @ManagedProperty("#{propertiesHolder}")
    private PropertiesHolder propertiesHolder;

    public void setPropertiesHolder(PropertiesHolder propertiesHolder) {
        this.propertiesHolder = propertiesHolder;
    }

    public boolean isEnabled() {
        return new Boolean(propertiesHolder.getProperty("enabled"));
    }

}