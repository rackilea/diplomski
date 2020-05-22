@POST
@Path("/upload")
@Consumes("multipart/form-data")
public Response uploadFile(MultipartFormDataInput input) {

  String fileName = "";
  Map<String, List<InputPart>> formParts = input.getFormDataMap();

  List<InputPart> inPart = formParts.get("file"); // "file" should match the name attribute of your HTML file input 
  for (InputPart inputPart : inPart) {
    try {
      // Retrieve headers, read the Content-Disposition header to obtain the original name of the file
      MultivaluedMap<String, String> headers = inputPart.getHeaders();
      String[] contentDispositionHeader = headers.getFirst("Content-Disposition").split(";");
      for (String name : contentDispositionHeader) {
        if ((name.trim().startsWith("filename"))) {
          String[] tmp = name.split("=");
          fileName = tmp[1].trim().replaceAll("\"","");          
        }
      }

      // Handle the body of that part with an InputStream
      InputStream istream = inputPart.getBody(InputStream.class,null);

      /* ..etc.. */
      } 
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  String msgOutput = "Successfully uploaded file " + filename;
  return Response.status(200).entity(msgOutput).build();
}