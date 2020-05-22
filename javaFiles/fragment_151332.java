@POST()
@Path("/{itemId}")
@Consumes(MediaType.APPLICATION_JSON)
public void addVote(@PathParam("itemId") Integer itemId, String body) {
    voteDAO.create(new Vote(body));
}