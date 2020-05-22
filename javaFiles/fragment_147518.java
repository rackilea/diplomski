@POST
@Produces("application/json")
@Consumes({ "application/xml", "application/json"})
@ApiOperation(
    value = "Short description of resources",
    notes = "Detailed textual description of the resource...",
    responseClass = "com.example.data.resps.PostExampleResp")
@ApiErrors(value = { @ApiError(code = 404, reason = "Resources Not Found"),
    @ApiError(code = 400, reason = "Bad Request"),
    @ApiError(code = 500, reason = "Internal Error")})
public PostExampleResp postExample(
    @ApiParam(value = "Description of request message",
        required = true) PostExampleReq request) 
    throws WebApplicationException{
    ...