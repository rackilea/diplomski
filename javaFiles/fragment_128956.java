@ApplicationPath("/rest")
public class App extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        // enable JSON support through Jackson
        classes.add(JacksonFeature.class);
        // my rest service
        classes.add(MyRESTService.class);
        return classes;
    }
}