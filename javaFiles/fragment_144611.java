@POST
    @Path("/urienodedeample")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uriEncodedExample(MultivaluedMap<String,String> multivaluedMap) {
        logger.info(multivaluedMap);
        return Response.status(200).build();
    }