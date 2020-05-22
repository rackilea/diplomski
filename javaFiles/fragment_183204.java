@DELETE
@Consumes(MediaType.APPLICATION_JSON)
@Path("/account/{accId}/user/{userId}")
public List<Users> deleteUser(@HeaderParam("token") String token, @PathParam("accId") 
        Integer accId, @PathParam("userId") Integer userId) {
    userService.deleteUser(userId);
    return userService.getUsers(accId);
}