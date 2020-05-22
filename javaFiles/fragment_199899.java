import javax.ws.rs.*;
import javax.ws.rs.core.Response.*;

import org.jboss.resteasy.client.*;
import org.jboss.resteasy.client.core.*;
import org.jboss.resteasy.client.core.executors.*;
import org.jboss.resteasy.mock.*;
import org.jboss.resteasy.plugins.providers.*;
import org.jboss.resteasy.spi.*;

public class InMemoryClientExecutorExample {
    public interface SimpleClient {
       @GET
       @Path("basic")
       @Produces("text/plain")
       String getBasic();

       @PUT
       @Path("basic")
       @Consumes("text/plain")
       void putBasic(String body);

       @GET
       @Path("queryParam")
       @Produces("text/plain")
       String getQueryParam(@QueryParam("param")String param);

       @GET
       @Path("matrixParam")
       @Produces("text/plain")
       String getMatrixParam(@MatrixParam("param")String param);

       @GET
       @Path("uriParam/{param}")
       @Produces("text/plain")
       int getUriParam(@PathParam("param")int param);
    }  

    public static void main(String[] args) {
        RegisterBuiltin.register(ResteasyProviderFactory.getInstance());

        ClientExecutor executor = new InMemoryClientExecutor() {
            @Override
            protected BaseClientResponse<?> createResponse(ClientRequest request, MockHttpResponse mockResponse) {
                try {                    
                    System.out.println("Client requesting " + request.getHttpMethod() + " on " + request.getUri());
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
                mockResponse.setStatus(Status.OK.getStatusCode());
                return super.createResponse(request, mockResponse);
            }
        };

        SimpleClient client = ProxyFactory.create(SimpleClient.class, "http://localhost:8081", executor);
        client.putBasic("hello world");
    }
}