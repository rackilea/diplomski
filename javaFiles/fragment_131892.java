@POST
@Path("/getById")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response getById(Client id) {
  try {    
    return Response.Ok(new ClientLogic().getById(id)).build();
  } catch (Exception ex) {
    return Response.status(201) // 200 means OK, I want something different
                   .entity(new RestError(status, msg))
                   .build();   
  }
}