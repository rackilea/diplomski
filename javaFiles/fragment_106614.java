@POST
@Path("/test/{id}")
@Override
public String testPost(@PathParam("id") String id){
    return "hello" + id;
}