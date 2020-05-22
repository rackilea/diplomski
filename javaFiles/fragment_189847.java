@GET
@Path("/logoutUser")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public Response logoutUser(@QueryParam("idUsuario") int idUsuario, @QueryParam("userName") String userName) {

    if(userName != null) {
        //do what you want with the username
    }
    else if (idUsuario == 1 || idUsuario == 2) {
        //do what you want with the id
    }
}