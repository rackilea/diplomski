@Path("/top/{top_id}")
@Component
public class Top{

  @GET
  @Path("/book")
  @Produces({"application/json"})
  public getBooks(){
  }

}

@Path("/top/{top_id}/middle/{middle_id}")
@Component
public class Middle{

  @GET
  @Path("/book")
  @Produces({"application/json"})
  public getBooks(){
  }

}