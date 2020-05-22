@Path("/process-something")
@POST
@Produces("application/json")
@Consumes("application/json")
public AResponse processSomething(MyJSONOject json) {
    log.fine(json.attribute);
}