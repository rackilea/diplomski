@POST
@Path("/save")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.TEXT_PLAIN)
public Response uploadFile(@FormDataParam("jesId") Integer jesId, @FormDataParam("label") String label,
        @FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetails) {

    CacheControl cc = new CacheControl();
    cc.setNoCache(true);
    return Response.ok(uploadUtility.uploadFile(jesId, label, uploadedInputStream, fileDetails, context)).cacheControl(cc).build();
}