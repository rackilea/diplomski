@POST
@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public Response uploadFile(@HeaderParam("uid") String userId) {

    return Response.status(200).entity("Done").build();
}