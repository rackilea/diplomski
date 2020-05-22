@GET
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public Response service(@QueryParam("format") String format) {
    return Response
            // Set the status, entity and media type of the response.
            .ok(entity, "json".equals(format) ? MediaType.APPLICATION_JSON : MediaType.APPLICATION_XML)
            .build();
}