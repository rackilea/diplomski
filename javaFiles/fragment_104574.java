@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("/local")
public Response specifyLocalFile()
    @FormParam("file") String fullFilePath,
    @FormParam("param1") String param1,
    @FormParam("param2") String param2,
    @FormParam("param3") String param3) {
    ....