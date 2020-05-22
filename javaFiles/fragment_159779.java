@GET
 @Path("/{format}/{part1}/{part2}/")
 public Response getCheck(@PathParam("format") String format, @PathParam("part1") String part1, @PathParam("part2") String part2, @Context UriInfo uriInfo) {
    MultivaluedMap<String, String> params = uriInfo.getQueryParameters();
    String x= params.getFirst("x");
    String y= params.getFirst("y");
}