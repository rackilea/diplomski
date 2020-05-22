@POST
@Path("/{uuid}/invoke/{method}")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public Response invokeMethod (
    MultivaluedMap<String,String> params,
    @PathParam("uuid") String uuid,
    @PathParam("method") String method
) {