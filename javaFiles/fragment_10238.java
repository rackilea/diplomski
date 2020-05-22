@ApplicationPath("one")
public class JAXRSConfigurationOne extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(FirstResource.class);
        return resources;
    }
}