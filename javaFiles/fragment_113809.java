@Path("/location/{locationId}{path:.*}")
public Response getLocation(
    @PathParam("locationId") int locationId,
    @PathParam("path") String path) {
    //your code
}