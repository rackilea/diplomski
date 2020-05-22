@POST
@Path("attachments")
public Response moveToMinio() throws Exception {
    TiedostoDaoImpl tiedostoDao = new TiedostoDaoImpl();
    Integer userId = tiedostoDao.getOneCustomerId();
    String uploadLink = AttachmentService.insertAndUploadService(userId);

    return Response.status(Response.Status.ACCEPTED).entity(uploadLink).build();
}