@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {

/**
* The default constructor.
*/
public ApplicationConfig() {

// Disable Moxy and use Jackson
this.property(ServerProperties.MOXY_JSON_FEATURE_DISABLE, true);

// Register own provider classes
this.register(Fully.Qualified.Path.To.Your.Service.class);

// Register Jackson provider
// Workaround for GF4.1 bug for details: https://java.net/jira/browse/GLASSFISH-21141
final ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(new JaxbAnnotationModule());
this.register(new JacksonJaxbJsonProvider(mapper, JacksonJaxbJsonProvider.DEFAULT_ANNOTATIONS));
}
}