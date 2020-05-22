@GET
@Path("testGet3")
@Produces(MediaType.APPLICATION_XML)
public String testGet3(@Context UriInfo uriInfo)
{
    MultivaluedMap<String, String> params 
            = uriInfo.getQueryParameters();
}