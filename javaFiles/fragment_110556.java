@Path("items/{itemId}/users")
public class RelatedUserResource {

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<User> getRelatedUsers(@PathParam("itemId") String itemId) {
        // returns the list of related users
    }

    // Other methods
}