@GET
@Path("/hello")
@Produces(MediaType.TEXT_HTML)
public Response helloWorld() {
    return Response.status(200).header("Content-Type", "application/json;charset=utf-8")
            .entity("Hello World with JSON").build();
}