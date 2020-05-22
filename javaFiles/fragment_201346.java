@POST
@Consumes("application/json")
@Produces("application/json")
public String post(String jsonRequest) {
    JSONObject jsonObject = new JSONObject(jsonRequest);
    return jsonObject.toString();
}