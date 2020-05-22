@POST
@Consumes({MediaType.APPLICATION_XML})
@Produces({MediaType.TEXT_PLAIN})
@Path("/post")
public String postPerson(String bodyRequest) throws Exception{
    // your code...
}