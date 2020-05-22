@GET
  @Path("/url")
  public Response getCallbackUrl() {
    String url = blobstoreService.createUploadUrl("/rest/file");
    return Response.ok(new FileUrl(url)).build();
  }