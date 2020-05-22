import javax.ws.rs.POST;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;

// (...)

    @POST
    @Path("/myservice/")
    public Response myService(@FormParam("url") final String url) {
      LOG.debug(String.format("Received URL: %s", url));
    }