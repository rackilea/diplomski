@Path("fruitstore")
public class FruitStore {

  @POST
  @Path("/checkobjectbyid")
  @Consumes(MediaType.APPLICATION_XML)
  public void loadObject(FruitBean bean) {
    System.out.println("====================");
    System.out.println("Fruit ID" + bean.getId() + " Name" + bean.getName());
  }

  @GET
  @Path("/fruitbean")
  @Produces(MediaType.APPLICATION_XML)
  public Response getFruitBean(){
    FruitBean fruitBean = new FruitBean();
    fruitBean.setId(1L);
    fruitBean.setName("name of fruitbean");
    return Response.status(Response.Status.OK).entity(fruitBean).build();
  }
}