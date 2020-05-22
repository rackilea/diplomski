@ApplicationPath("/api/1")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);

        // Add Jackson feature.
        resources.add(org.glassfish.jersey.jackson.JacksonFeature.class);

        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        // JAX-RS resource classes added here - maintained by NetBeans.
    }
}