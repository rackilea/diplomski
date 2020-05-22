@POST
@Consumes(MediaType.APPLICATION_JSON)
@Path("/putOtdDebt")
public Response putOtdDebt(String body) {

 System.out.println("body: " + body);
  }