@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response upload(MultipartFormDataInput input) throws Exception {
    Map<String, Object> json = input.getFormDataPart("json", new GenericType<Map<String, Object>>() {});
    InputStream image = input.getFormDataPart("image", new GenericType<InputStream>() {});
    return Response.ok().build();
}