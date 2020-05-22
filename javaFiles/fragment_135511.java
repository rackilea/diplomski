@GET
@Produces(MediaType.TEXT_PLAIN)
@Path("/<your-path>")
public Response hello() {
    StreamingOutput stream = new StreamingOutput() {
        @Override
        public void write(OutputStream os) throws IOException, WebApplicationException {
            Writer writer = new BufferedWriter(new OutputStreamWriter(os));

            for (...) {
                writer.write(...);
            }
            writer.flush();
        }
    };
    return Response.ok(stream).build();
}