@ApplicationPath("geo")
public class MainApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(MainResource.class);
        return classes;
    }
}