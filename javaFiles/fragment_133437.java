@GET
@Path("getObj/{param}") 
@Produces("application/json")
public Response getObj(@PathParam("param") String msg) {

    ListUser responses = new ListUser();
    responses.add(new User("1"));
    responses.add(new User("2"));
    responses.add(new User("3")); 
    if("list".equals(msg))
        return Response.status(200).entity(responses).build();
    User u=new User();
    u.setName("Developer");
    return Response.status(200).entity(u).build();


}