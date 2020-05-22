@POST
@Path("/foo")
@Consumes("application/json")
public Response fooService(MyObject obj) {
   MyResponseEntity entity = MyObjectService.retrieveSomethingFrom(obj);
   return Response.status(200).entity(entity).type(obj.isXml() ? "text/xml" : "application/json").build();
}