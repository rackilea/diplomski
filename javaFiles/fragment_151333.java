@POST()
@Path("/{itemId}")
@Consumes(MediaType.APPLICATION_JSON)
public void addVote(@PathParam("itemId") Integer itemId, Vote vote) {
    voteDAO.create(vote);
}