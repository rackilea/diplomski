@ApplicationPath("/rest")
public class RestApplication extends Application {
    // All request scoped resources and providers
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(DukesAgeResource.class);
        return classes;
    }

    // all singleton resources and providers
    @Override
    public Set<Object> getSingletons() {
        Set<Object> singletons = new HashSet<>();
        return singletons;
    }
}