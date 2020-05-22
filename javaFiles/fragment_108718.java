@Path("images")
public interface ImageResource {
    enum Size {
        thumbnail, small, normal, original, custom
    }

    @GET
    @Path("/{id}")
    @Produces("image/jpeg")
    byte[] getImage(@PathParam("id") long id, @QueryParam("size") @DefaultValue("thumbnail") Size size, @QueryParam("width") Integer width, @QueryParam("height") Integer height);
}