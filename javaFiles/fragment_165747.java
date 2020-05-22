@Path("/upload")
class UploadResource {

    @POST
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public Response upload(byte[] input) {
        // store input somewhere
        return Response.ok().build();
    }

}