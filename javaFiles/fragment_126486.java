@POST
@Path("/receiverMessage")
@Consumes ( { MediaType.APPLICATION_JSON })
@Produces ( { MediaType.TEXT_PLAIN })
public Response sendMessage(Broadcast broadcast) {
   System.out.println(broadcast.getSenderName());
   System.out.println(broadcast.getReceiverName());
   System.out.println(broadcast.getTime());
   return Response.ok().status(200).entity("SUCCESS").build();
}