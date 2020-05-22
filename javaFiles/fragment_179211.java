@ApplicationPath("resources")
public class RestApplication extends ResourceConfig {
    public RestApplication() {
        HashSet<Class<?>> c = new HashSet<Class<?>>();
        c.add(PersonsRestService.class);
        c.add(ProjectsRestService.class);

        //add this
        c.add(HeaderResponseFilter.class);


        Set<Class<?>> classes = Collections.unmodifiableSet(c);
        registerClasses(classes);

        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }
}