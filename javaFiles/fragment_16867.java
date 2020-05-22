@POST
@Path("/buzz")
@Produces(...)
public Response createBuzz(Buzz buzz, @Context UriInfo uriInfo) {
    int buzzID = // create buzz and get the resource id
    UriBuilder builder = uriInfo.getAbsolutePathBuilder();
    builder.path(Integer.toString(buzzId));  // concatenate the id.
    return Response.created(builder.build()).build();
}