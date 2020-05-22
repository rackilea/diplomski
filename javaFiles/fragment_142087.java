@GET
@Produces(MediaType.TEXT_PLAIN)
public Response sayPlainTextHello() {
    try
    {
         return Response.status(200).entity(someRemoteServerApi.getHelloString()).build();
    }
    catch(exception ex)
    {
         return Response.status(500).entity(getErrorMessageString()).build();
    }
}