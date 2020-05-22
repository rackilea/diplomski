import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import junit.framework.Assert;

import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.junit.Test;

public class TestCase {
    @Path("/")
    public static class Service {

        @Path("")
        @GET
        public String get(@Form ValueObject vo){
            return vo.getParam();
        }
    }

    public static class ValueObject {
        @QueryParam("myparam")
        private String param;

        public String getParam() {
            return param;
        }
    }

    @Test
    public void test() throws Exception {
        Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
        dispatcher.getRegistry().addSingletonResource(new Service());

        MockHttpRequest request = MockHttpRequest.get("/?myparam=somevalue");
        MockHttpResponse response = new MockHttpResponse();

        dispatcher.invoke(request, response);

        Assert.assertEquals("somevalue", response.getContentAsString());
    }
}