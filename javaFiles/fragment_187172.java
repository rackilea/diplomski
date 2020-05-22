@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getResult(@Context UriInfo uriInfo) {
   // you might need to play around with this. I'm not sure exactly
   // the base will be. Do some debugging if needed.
   URI uri = uriInfo.getBaseUriBuilder()
           .path("/API/v1/keys")
           .build();
   WebTarget target = client.target(uri);
   Response response = target.request().get();
   ...
}