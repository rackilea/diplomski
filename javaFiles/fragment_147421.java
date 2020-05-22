@POST
@Consumes(MediaType.APPLICATION_JSON)
@Path("/putOtdDebt")
public Response putOtdDebt(Pojo body) {

System.out.println("username: " + body.getUsername());
System.out.println("password: " + body.getPassword());
  }