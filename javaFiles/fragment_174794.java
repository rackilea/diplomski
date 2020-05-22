@GET
@Path("getall/{name: .*}")
@Produces("application/json")
public Object Getall(@PathParam("name") String customerName) {
      //here I want to call SQL if customerName is not null. is it possible???
}