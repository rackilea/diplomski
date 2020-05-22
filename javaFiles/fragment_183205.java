@DELETE
@Consumes(MediaType.APPLICATION_JSON)
@Path("/user/{userId}")
public void deleteUser(@HeaderParam("token") String token, @PathParam("userId") Integer userId) {
    userService.deleteUser(userId);
}

@GET
@Consumes(MediaType.APPLICATION_JSON)
@Path("/user")
public List<Users> getUsers(@HeaderParam("token") String token, @QueryParam("accId") Integer accId) {
    return userService.getUsers(accId);
}