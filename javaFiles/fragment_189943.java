@POST
@Path("/coverpic")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadFile(FormDataMultiPart multiPart){
     FormDataBodyPart body = multiPart.getField(<your fieldname>);
     InputStream ins = ((BodyPartEntity) body.getEntity()).getInputStream();
     ///.....
     ///.....
     return Response.status(200).entity(output).build();

}