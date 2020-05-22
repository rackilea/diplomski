@ApiOperation(value = "Post a object", notes = "")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Returns the posted object") })
@POST
@Consumes("application/json")
@Produces("application/json")
@Path("/create")
public Response create(String object) {
    JSONObject json = JSONObject.parse(object);
    logger.info("Object retrieved"); 
    logger.info(json);
    return Response.ok(json).build();
}