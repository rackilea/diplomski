public class RESTConfig extends ResourceConfig {
    public RESTConfig() {
        // scan the whole package and register all appropriate classes
        packages("org.foo.rest;org.bar.rest");
        // register single class
        register(CORSFilter.class);
    }
}