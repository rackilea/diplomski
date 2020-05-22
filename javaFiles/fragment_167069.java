@Path("/")
public class Foo {
  private UriInfo uriInfo;
  @Context
  public void setUriInfo(UriInfo info) {
    this.uriInfo = info;
  }
  // ...
}