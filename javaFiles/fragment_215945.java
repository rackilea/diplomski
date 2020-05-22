@GET
@Path("/property/{uuid}")
public Response getQuery(@PathParam("uuid") String uuid, 
                         @Context UriInfo uriInfo) {

    MultivaluedMap params = uriInfo.getQueryParameters();
    StringBuilder builder = new StringBuilder();
    for (Object key : params.keySet()) {
        builder.append(key).append(":")
               .append(params.getFirst(key)).append("\n");
    }
    return Response.ok(builder.toString()).build();
}