@POST
@Path("{id}/test-db-requests")
public Response giveNodes(final Pet pet, @PathParam("id") final String id){

    //do stuff for POST with an instance of pet here (useful for non
    //polymorphic resources

}