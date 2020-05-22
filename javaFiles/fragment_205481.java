@GET
@Path("/get/{id}/{chunk}")
public Response getDescription(@PathParam("id") final String id, @PathParam("chunk") final String chunk) {
{

    StreamingOutput fileStream =  new StreamingOutput()
    {
        @Override
        public void write(java.io.OutputStream output, String id2) throws IOException, WebApplicationException 
        {
            try
            {
                if (Objects.equals(chunk, new String("init"))) {
                    java.nio.file.Path path = Paths.get("src/main/uploads/example/frame_init.pdf");
                }
                else {
                    java.nio.file.Path path = Paths.get("src/main/uploads/example/"+ id2 +".pdf");
                }
                byte[] data = Files.readAllBytes(path);
                output.write(data);
                output.flush();
            } 
            catch (Exception e) 
            {
                throw new WebApplicationException("File Not Found !!");
            }
        }
    };
    return Response
            .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
            .header("content-disposition","attachment; filename = myfile.pdf")
            .build();
}