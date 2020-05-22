@POST
@Path("/")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadFile(final MimeMultipart file) {
    if (file == null)
        return Response.status(Status.BAD_REQUEST)
                .entity("Must supply a valid file").build();

    try {
        for (int i = 0; i < file.getCount(); i++) {
            System.out.println("Body Part: " + file.getBodyPart(i));
        }
        return Response.ok("Done").build();
    } catch (final Exception e) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e)
                .build();
    }
}