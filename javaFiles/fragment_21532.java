@Context UriInfo uriInfo;

public URI getUri()
{
  return uriInfo.getBaseUriBuilder().path(MyResource.class).build();
}