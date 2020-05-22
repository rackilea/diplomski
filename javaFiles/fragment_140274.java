@Path("/entry-point")
public class EntryPoint
{
    private final Logger logger = Logger.getLogger(EntryPoint.class);

    @GET
    @Path("/test/{param}")
    public Response test(@PathParam("param") String param)
    {
        logger.info("Received message " + param);
        String output = "Hi : " + param;
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/test2/{param}")
    public String test2(@PathParam("param") String param)
    {
        logger.info("Received message " + param);
        return "yo";
    }
}