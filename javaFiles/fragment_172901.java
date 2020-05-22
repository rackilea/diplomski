@POST
 @Path("/upload1")
 @Consumes(MediaType.MULTIPART_FORM_DATA)
 public Response createFile1(@FormDataParam("doc") FormDataBodyPart part) {
    part.setMediaType(MediaType.APPLICATION_JSON_TYPE);
    Test doc = part.getValueAs(Test.class);
    return Response.ok(doc.getName()).build();
 }