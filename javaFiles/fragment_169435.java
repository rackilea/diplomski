@GET
@Produces("application/json")
@Path("/carMovements")
public String getCarMovement() {
    Gson gson = new Gson();
    return gson.toJson(service.getCarMovements());
}