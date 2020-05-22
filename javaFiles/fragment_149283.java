@Path("resource")
public class SubTypeResource implements Resource<SubType> {
    @POST
    @Override
    public Response doSomething(SubType type) {
        ...
    } 
}