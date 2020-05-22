@GET
@Produces(MediaType.TEXT_PLAIN)
@Path("/spring-rest/ex/qstring")
public String getStuffAsMapping(@Context UriInfo uriInfo) { 
    String query = uriInfo.getRequestUri().getQuery();
    ...
}