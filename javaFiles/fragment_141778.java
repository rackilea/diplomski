@ApplicationPath("/rest")
public class RestConfiguration extends Application {

    private Set<Class<?>> resources = new HashSet<Class<?>>();

    public RestConfiguration () {
        resources.add(RegistrationRest.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return resources;
    }

}