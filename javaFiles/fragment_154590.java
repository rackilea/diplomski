@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response createUser(String content) throws CityNotFoundException
{
    ReceivedCreateUser receivedUser = gson.fromJson(content, ReceivedCreateUser.class);
    User createdUser = userFacade.createUser(receivedUser.name,
                                         receivedUser.email,
                                         receivedUser.password,
                                         receivedUser.city,
                                         receivedUser.gender,
                                         receivedUser.dateOfBirth);
    if(createdUser == null){
       throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
    return Response
       .created(new Uri("http://example.org"))
       .entity(gson.toJson(UserDTO.basic(createdUser)))
       .build();
}