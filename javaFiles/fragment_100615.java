@POST
    @Path("/test_upload_files")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response testHandler(
                    @HeaderParam("Authorization") String auth,
                    @FormDataParam("file") InputStream uploadedInputStream,
                    @FormDataParam("file") FormDataContentDisposition fileDetail,
                    @FormDataParam("json_data") InputStream jsonStream) throws IOException {
            String encoding = "UTF-8";
            JSONObject jsonObject;

            StringWriter writer = new StringWriter();

            IOUtils.copy(jsonStream, writer, encoding);

            String input = writer.toString();

            try {
                    jsonObject = new JSONObject(input);
                    id = jsonObject.getString("id");
                    country = jsonObject.getString("country");
            } catch (JSONException e) {
                    return null;
            }

    }