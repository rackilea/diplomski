@Produces(MediaType.APPLICATION_JSON)
public Response getValues() {
        return Response.status(200)
                 .entity(new MyObject())
                 .expires(new Date())
                 .header("Pragma", "no-cache")
                 .type(MediaType.APPLICATION_JSON);
}