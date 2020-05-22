@POST
@Path("/test2")
public void test2(@Context HttpServletRequest request) {

    ...

    Response response = client.target("http://ip-api.com/json/" + ip)
        .request(MediaType.TEXT_PLAIN_TYPE)
        .header("Accept", "application/json").get();

   Geolocation location = response.readEntity(Geolocation.class);
   response.close();

   // now the instance of Geolocation contains all data from the message
}