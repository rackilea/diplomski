@GET
@Path("request=getTile")
@Produces({"image/png"})
public Response getTileGET(...) {

    BufferedImage image = ...;

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(image, "png", baos);
    byte[] imageData = baos.toByteArray();

    // uncomment line below to send non-streamed
    // return Response.ok(imageData).build();

    // uncomment line below to send streamed
    // return Response.ok(new ByteArrayInputStream(imageData)).build();