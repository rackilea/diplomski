@ManagedBean
@RequestScoped
public class SomeBean {

    @ManagedProperty("#{propertiesHolder.getProperty('enabled')}")
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}