@POST
@Path("/upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadPicture(@FormDataParam("data") byte[] imageBytes, @FormDataParam("fileName") String fileName) {

    String uploadedFileLocation = UPLOAD_FOLDER + fileName;

    try {
        OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
        out.write(imageBytes);
        out.flush();
        out.close();
    } catch (IOException e) {       
        logger.severe("Can not save file (file location: " + uploadedFileLocation + ")");
        return Response.status(500).entity("Can not save file<br>" + e.toString()).build();
    }

    return Response.status(200).entity("success").build();
}