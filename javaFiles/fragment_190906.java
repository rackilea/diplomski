@GET
@Path("/{id}")
public Response getMe(
            final @PathParam("id") String id,
            @Context HttpServletRequest req) {

     System.err.println(req.getRemoteAddr());