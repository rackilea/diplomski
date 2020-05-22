@GET
@Path("/{version}/{accountId}/search")
@Produces(MediaType.APPLICATION_JSON)
public String search(@PathParam("version") String version,
                     @PathParam("accountId") String accountId,
                     @Context HttpServletRequest request);