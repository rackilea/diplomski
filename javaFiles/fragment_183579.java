@GET
@Secured
@Path("{id}")
@Produces(MediaType.APPLICATION_JSON)
public Response myMethod(@PathParam("id") Long id, 
                         @Context SecurityContext securityContext) {
    ...
}