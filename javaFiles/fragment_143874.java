@POST
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML  })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public Response myPostService(@HeaderParam("Accept") String accepted, 
                              MyObject inTheRequestBody) {
   MediaType mediaType = MediaType.APPLICATION_JSON; // the default
   if(accepted != null) {
       mediaType = MediaType.valueOf(accepted);
   }
   // service logic
   return Response.ok().entity(/*the object you want to return*/).type(mediaType).build();
}