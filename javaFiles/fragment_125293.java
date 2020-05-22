@GET
@Produces(MediaType.APPLICATION_XML)
public Response getMessage() {
    MessageServices obj = new MessageServices();
    List<messagesDTO> res = obj.getAllMessages();
    return Response.ok().entity(res).build();
}