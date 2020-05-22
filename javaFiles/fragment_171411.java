import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

public class MockHttpSevletRequestTest extends JerseyTest {

    @Path("http")
    public static class HttpResource {
        @GET
        public Response getResponse(@Context HttpServletRequest request) {
            return Response.ok(request.getMethod()).build();
        }
    }

    @Override
    public Application configure() {
        ResourceConfig config = new ResourceConfig(HttpResource.class);
        config.register(new AbstractBinder() {
            @Override
            public void configure() {
                bindFactory(HttpServletRequestFactory.class)
                        .to(HttpServletRequest.class);
            }
        });
        return config;
    }

    public static class HttpServletRequestFactory implements Factory<HttpServletRequest> {

        @Override
        public HttpServletRequest provide() {
            return new MockHttpServletRequest();
        }

        @Override
        public void dispose(HttpServletRequest t) {
        }
    }

    @Test
    public void test() {
        String response = target("http").request().get(String.class);
        System.out.println(response);
        Assert.assertEquals("POST", response);
    }
}