@Path("/static1/{variable}/static2")
    public class DoStuff {

    @POST
    @Path("/{segment3:static3.*}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces("application/xml")
    public Response validation(@PathParam("variable") String variable,
                               @PathParam("segment3") String segment3, 
                               String inputXML) {
       ...............
    }