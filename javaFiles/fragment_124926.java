@POST
@Consumes("application/json")
@Path("{id}/test-db-requests")
public Response giveNodes(final String pet, @PathParam("id") final String id){

    //do stuff for POST with a strigified JSON here

}