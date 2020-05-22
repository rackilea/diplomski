@PUT
@Path("/{directory:.+}")
@Consumes("application/x-www-form-urlencoded")
public Response doPut(@PathParam("directory") String directory,
                      @FormParam byte[] image,
                      @FormParam String metadata) {
    ...
}