@Path("/{fileName: .+}")
@Produces(MediaType.TEXT_HTML)
public class HtmlResource {

    @GET
    public Response getPage(@PathParam("fileName") String fileName) throws IOException {
        InputStream stream = HtmlResource.class.getClassLoader()
                                 .getResourceAsStream(fileName);
        String responseContent = read(stream);
        return Response.ok(responseContent).build();
    }

    private String read(InputStream stream) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(
                                             stream, StandardCharsets.UTF_8))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }
}