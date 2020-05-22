@GET
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public Response service(@QueryParam("format") String format) {
    return Response
            // Set the status and Put your entity here.
            .ok(entity)
            // Add the Content-Type header to tell Jersey which format it should marshall the entity into.
            .header(HttpHeaders.CONTENT_TYPE, "json".equals(format) ? MediaType.APPLICATION_JSON : MediaType.APPLICATION_XML)
            .build();
}