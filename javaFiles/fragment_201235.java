@GET
@Produces(MediaType.APPLICATION_OCTET_STREAM)
@Path("path")
public StreamingOutput getFile() {
    return new StreamingOutput() {
        public void write(OutputStream out) throws IOException, WebApplicationException {
            try {
                 FileInputStream in = new FileInputStream(my_file);
                 byte[] buffer = new byte[4096];
                 int length;
                 while ((length = in.read(buffer)) > 0){
                    out.write(buffer, 0, length);
                 }
                 in.close();
            } catch (Exception e) {
                throw new WebApplicationException(e);
            }
        }
    };
}