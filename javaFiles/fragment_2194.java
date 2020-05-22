@Path("/v1/restclienturi/")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public interface RestClient {

    @POST
    @Path("/samplecall/evaluate")
    Response evaluateChange(
            @Form MyHeader headers,
            @Context HttpServletResponse response, Request request);
}