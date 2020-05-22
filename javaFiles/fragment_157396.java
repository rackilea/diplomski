package jersey.example;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class JerseyTestFilter implements ContainerResponseFilter {
@Override 
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
       String resp = (String) response.getEntity();
       resp += " - filter applied";
      response.setEntity(resp);
      return response;
    }
}