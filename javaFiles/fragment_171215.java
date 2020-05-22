//Rest API
         @GET
    @Path("/get/{username}/{password}")
    public void login(@PathParam("username") String userName, @PathParam("password") String pwd){
    }
//Jersey

    ClientResponse resp = webR.accept("text/html")
    .path(userName)
    .path(password)
    .get(ClientResponse.class);