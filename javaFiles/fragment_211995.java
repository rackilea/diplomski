@GET
@Produces("application/xml;version=1")
public Response getAddonListVersion1(@Context UriInfo uriinfo) {
    logger.debug("START:Addons Dummy Service Implementation");

    return Response.ok("Version 1", "application/xml").build();
}

@GET
@Produces("application/xml;version=2")
public Response getAddonListVersion1(@Context UriInfo uriinfo) {
    logger.debug("START:Addons Dummy Service Implementation");

    return Response.ok("Version 2", "application/xml").build();
}