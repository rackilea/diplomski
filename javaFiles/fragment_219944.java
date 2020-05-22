@POST
@Path("/{department}/{team}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response handleJSON(String json, @PathParam("department") String department,       @PathParam("team") String team){ 

    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readValue(json, JsonNode.class);

    MyObj myObj = new MyObj();

    myObj.setDepartment(department);
    myObj.setTeam(team);

    if (node.get("platform") != null) {
        myObj.setPlatform(node.get("platform").textValue());
    }

    saveObj(myObj);

    return Response.ok(true).build();

}