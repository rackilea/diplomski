@GET
@Produces(MediaType.TEXT_HTML)
public String performFooCall() {
    if (isNormal()) {
        return "Hello";
    }
    throw new WebApplicationException(Response.status(500).entity("Hello").build());
}