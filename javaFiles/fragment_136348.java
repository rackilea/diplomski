@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public CD addCD(@FormParam("artist") String artist,
                @FormParam("title") String title,
                @FormParam("numberOfTracks") int numberOfTracks) {

}