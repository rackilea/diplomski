@Post
    @Path("user/in")
    @Produces(MediaType.APPLICATION_JSON)
    public Response InsertUser(string json){
      JsonElement jsonElement = new JsonParser().parse(json);
      JsonObject object = jsonElement.getAsJsonObject();
      String name = object.getAsJsonPrimitive("name").getAsString();
      int userID = object.getAsJsonPrimitve("userID").getAsInt();
      String password = object.getAsJsonPrimitive("password").getAsString();
      String job = object.getAsJsonPrimitive("job").getAsString();
      int active = object.getAsJsonPrimitve("active").getAsInt();
      int profile = object.getAsJsonPrimitve("profile").getAsInt();



      return Response.status(Response.Status.OK).entity("all done").build();


    }