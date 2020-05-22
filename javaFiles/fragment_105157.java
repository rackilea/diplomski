public class UserDomain {

    private Boolean enabled;

    public UserDomain() {
         this.enabled = ApplicationContextProvider.getEnvironmentProperty("default.user.enabled", Boolean.class, false);
    }

    ...
}