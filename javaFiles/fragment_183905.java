import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class UriInfoTest extends JerseyTest {

    public static interface Service {
        String getUri();
    }

    public static class ServiceOne implements Service {

        @Context 
        UriInfo uriInfo;

        @Override
        public String getUri() {
            return uriInfo.getRequestUri().toASCIIString();
        }
    }

    public static class ServiceTwo implements Service {
        @Override
        public String getUri() {
            return "Blah";
        }
    }

    public static class ObjType {
        String param;
        public ObjType(String param) {
            this.param = param;
        }
    }

    static class RestUtils {
        static Service getServiceByType(ObjType type) {
            switch (type.param) {
                case "one": return new ServiceOne();
                case "two": return new ServiceTwo();
                default: return new ServiceOne();
            }
        }
    }

    public static class ServiceFactory implements Factory<Service> {

        @QueryParam("type")
        ObjType type;

        @Inject
        ServiceLocator locator;

        @Override
        public Service provide() {
            Service service = RestUtils.getServiceByType(type);
            if (service instanceof ServiceOne) {
                locator.inject(service);
            }
            return service;
        }

        @Override
        public void dispose(Service t) {}     
    }

    public static class Binder extends AbstractBinder {
        @Override
        protected void configure() {
            bindFactory(ServiceFactory.class).to(Service.class);
        }
    }

    @Path("uri")
    public static class UriResource {

        @Inject
        Service service;

        @GET
        public String get() {
            return service.getUri();
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(UriResource.class)
                .register(new Binder())
                .register(new LoggingFilter(Logger.getAnonymousLogger(), true));
    }

    @Test
    public void doit() {
        Response response = target("uri").queryParam("type", "one").request().get();
        assertEquals(200, response.getStatus());
        String message = response.readEntity(String.class);
        assertEquals("http://localhost:9998/uri?type=one", message);
        response.close();
    }
}