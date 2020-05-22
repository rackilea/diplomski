@Path("users/{userId}/items")
public class RelatedItemResource {

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Item> getRelatedItems(@PathParam("userId") String userId) {
        // returns list of related items
    }

    // Other methods    
}