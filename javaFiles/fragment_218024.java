// receive List of Strings
@GET
@Path("/receiveListOfStrings")
public Response receiveListOfStrings(@QueryParam("list") final List<String> list){
    log.info("receieved list of size="+list.size());
    return Response.ok().build();
}