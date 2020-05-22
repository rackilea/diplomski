@Component
@Provider
@Consumes({"application/*+json", "text/json"})
@Produces({"application/*+json", "text/json"})
public class JacksonProvider extends JacksonJsonProvider {
    public JacksonProvider() {
        setMapper(new CustomObjectMapper());
    }
}