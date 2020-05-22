public class SomeClass {
    private JsonNode copiedTool;

    @POST @Path("/tools")
    public Response createTool(JsonNode tool) throws URISyntaxException {

        setCopiedTool(tool);

        String type= tool.get("type").asText();

        return Response.status(201).entity(getCopiedTool()).build().created(new URI("/tools/"+type)).build();
    }

    @GET @Path("/tools/{type}")
    public Response getToolInfo(@PathParam("type") String type) {

        if(getCopiedTool().get("type").equals(type)) {
            return Response.ok(getCopiedTool()).build();
        }
        return Response.status(204).build();
    }


    public JsonNode getCopiedTool() {
        return copiedTool;
    }

    public void setCopiedTool(JsonNode copiedTool) {
        this.copiedTool = copiedTool;
    }
}