@GET
@Path("sin")
@Produces(MediaType.TEXT_PLAIN)
public Response hello() {
    String var = "[0.0, 0.0]";      
    return Response.ok().entity(var)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
            .allow("OPTIONS").build();
}