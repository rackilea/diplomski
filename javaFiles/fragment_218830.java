@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces({MediaType.APPLICATION_JSON})
public Response uploadFile(
    @FormDataParam("file") InputStream uploadedInputStream,
    @FormDataParam("file") FormDataContentDisposition fileDetail) throws Exception {

    String filename = fileDetail.getFileName();
    String uploadedFileLocation = "C:\\surveymedia\\media" + filename;
    try {
        saveFile(uploadedInputStream, uploadedFileLocation);
    }
    catch(Exception e){
        return Response.status(400).entity(e.getCause()).build();
    }

    String output = "File uploaded to: " + uploadedFileLocation;
    return Response.status(200).entity(output).build();
}