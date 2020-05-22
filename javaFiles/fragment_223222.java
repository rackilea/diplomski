import java.net.URI;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class Program {
    public static void main(final String[] args) {
        final URI uri = URI.create("http://0.0.0.0:8080/");
        final ResourceConfig resourceConfig = new ResourceConfig(TestResource.class);
        resourceConfig.register(MultiPartFeature.class);
        resourceConfig.register(JacksonFeature.class);
        JettyHttpContainerFactory.createServer(uri, resourceConfig);
    }
}