@POST
@Path("/test2")
public void test2(@Context HttpServletRequest request) {

    ...

    Response response = client.target("http://ip-api.com/json/" + ip)
        .request(MediaType.TEXT_PLAIN_TYPE)
        .header("Accept", "application/json").get();

   String json = response.readEntity(String.class);
   response.close();

   // now you can do with json whatever you want to do
}