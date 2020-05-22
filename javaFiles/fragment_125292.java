@GET
@Produces(MediaType.APPLICATION_XML)
public List<messagesDTO> getMessage() {
    MessageServices obj = new MessageServices();
    List<messagesDTO> res = obj.getAllMessages();
    return res;
}