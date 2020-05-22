@Path("test")
@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public String testForm(@FormParam("accept") String accept) {
    return accept;
}