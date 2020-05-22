@ApplicationPath("/")
public class RestApplication extends Application {

    Set<Class<?>> classes;

    public RestApplication(@Context ServletContext servletContext) {
        classes = new HashSet<>();
        try {
            URI resourcesConfig = servletContext.getResource("/WEB-INF/resources.txt").toURI();
            List<String> resources = Files.readAllLines(Paths.get(resourcesConfig), Charset.forName("UTF-8"));
            for (String resource : resources) {
                parseResources(resource);
            }
        } catch (IOException | URISyntaxException | ClassNotFoundException ex) {
            throw new IllegalArgumentException("Could not add resource classes", ex);
        }
    }

    private void parseResources(String resource) throws ClassNotFoundException, IOException {
        if (!resource.endsWith(".*")) {
            classes.add(Class.forName(resource));
            return;
        }
        String pkg = resource.substring(0, resource.length() - 2);
        Reflections reflections = new Reflections(pkg);
        for (Class<?> scannedResource : reflections.getTypesAnnotatedWith(Path.class)) {
            classes.add(scannedResource);
        }
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

}