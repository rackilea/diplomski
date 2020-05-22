@GET
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Path("/foo")
public GenericEntity<List<String>> stringlist()
{
  List<String> list = Arrays.asList("test", "as");

  return new GenericEntity<List<String>>(list) {};
}