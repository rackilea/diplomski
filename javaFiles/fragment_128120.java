public abstract class AbstractFamilyMember {

    @GET
    @Path("children")
    public Response children(@Context UriInfo uriInfo) {

        MultivaluedMap<String, String> pathParameters = uriInfo.getPathParameters();
        String grandfatherName = pathParameters.getFirst("grandfatherName");
        String fatherName = pathParameters.getFirst("fatherName");
        String sonName = pathParameters.getFirst("sonName");

        return Response.ok().build();
    }
}