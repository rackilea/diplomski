package rest;

@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig(){
        register(MultiPartFeature.class);
        packages("rest");
    }
}