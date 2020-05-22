@POST
  @Path("upload")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Response uploadFile(@MultipartForm FileUploadForm form) throws IOException
  {
    if (form == null) {
      return Response.status(Response.Status.PRECONDITION_FAILED).build();
    }

    Files.write(Paths.get(MEDIA_BASE_PATH + "/test.gif"), form.getData());

    return Response.status(Response.Status.OK).build();
  }