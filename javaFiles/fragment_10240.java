@ApplicationPath("two")
public class JAXRSConfigurationTwo extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(SecondResource.class);
        return resources;
    }
}