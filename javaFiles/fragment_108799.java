@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces("application/pdf")
public Response downloads() throws IOException {

    File file = new File("myFile.pdf");

    InputStream fileStream = new FileInputStream(file);

    byte[] data = new byte[1024];

    ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    int read = 0;
    while ((read = fileStream.read(data, 0, data.length)) != -1) {
        buffer.write(data, 0, read);
    }

    buffer.flush();

    fileStream.close();

    ResponseBuilder response = Response.ok(Base64.encodeBase64(buffer.toByteArray()));
    response.header("Content-Disposition", "attachment; filename=myFile.pdf");
    Response responseBuilder = response.build();
    return responseBuilder;
}