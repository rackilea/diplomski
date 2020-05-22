//Rest API
    @GET
    @Path("/get")
    public void login(@QueryParam("username") String username, @QueryParam("password") String pwd){

//Jersey
ClientResponse resp = webR.accept("text/html")
.queryParam("username", userName)
.queryParam("password", pwd)
.get(ClientResponse.class);