@Path("static")
public class StaticContentHandler {
  ...
  @GET
  @Path("{path:.*}")
  public FileRepresentation Get(@PathParam("path") String path) {
    ...;
  }
}