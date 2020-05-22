@POST
@Path("/yourservice")
@Consumes({ MediaType.APPLICATION_JSON})
@Produces({
        MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML})
public Result postYourService(YourData data) throws WebApplicationException;