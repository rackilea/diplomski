@Path("file")
public class FileResource {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response handleUpload(@FormDataParam("file") InputStream stream) throws Exception {
        return Response.ok(IOUtils.toString(stream)).build();
    }
}