@GET
@Path("{id}")
@Produces(MediaType.APPLICATION_JSON)
public Response foo(@PathParam("id") Long id, 
                    @Context SecurityContext securityContext) {
    ...
}