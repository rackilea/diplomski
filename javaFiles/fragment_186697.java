@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.TEXT_PLAIN)
public String getTest(@FormDataParam("file") InputStream in,
                      @FormDataParam("file") FormDataContentDisposition fdc) {
    try (FileOutputStream out = new FileOutputStream(fdc.getFileName())) {
        ReaderWriter.writeTo(in, out);
    } catch (IOException ex) {
        ex.printStackTrace(System.out);
        return "Bad $#!t happended";
    }
    return "Upload OK";
}

@Test
public void doit() {
    File file = new File("...");
    FileDataBodyPart filePart = new FileDataBodyPart("file", file);
    MultiPart entity = new FormDataMultiPart()
            .bodyPart(filePart);
    Client client = Client.create();
    WebResource resource = client.resource("http://localhost:9998/service");
    ClientResponse response = resource
            .type(MediaType.MULTIPART_FORM_DATA_TYPE)
            .post(ClientResponse.class, entity);
    assertEquals(200, response.getStatus());
    assertEquals("Upload OK", response.getEntity(String.class));
    response.close();
}