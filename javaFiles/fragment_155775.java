@GET
@Produces(MediaType.APPLICATION_JSON)
public Response displayInfo() {
    JSONObject json = createInfoJson();
    return Response.ok(json.toString()).build();
}