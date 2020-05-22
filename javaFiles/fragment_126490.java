public class Resource {

  @JsonView(Views.Public.class)
  @GET
  @Produces(MediaType.APPLICATION_JSON )
  public List< User > getElements() {
    //do something
    return someResultList;
  }
}