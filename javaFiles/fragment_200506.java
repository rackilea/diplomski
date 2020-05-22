@POST
@Path("/create")
@Produces(MediaType.APPLICATION_JSON)
public Us createUser(JsonObject jsonObject){
    int age=jsonObject.get("age");

    int id=jsonObject.get("id");
    String city=jsonObject.get("city");
    String country=jsonObject.get("country");
    String name=jsonObject.get("name");
    return userRegistrator.createUs(id,age,city,country,name);
}