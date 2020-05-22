@POST
@Path("webhook")
@Produces(MediaType.APPLICATION_JSON)
public Response webhookListener(NotificationConfiguration nc) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = mapper.writeValueAsString(nc);
    System.out.println(jsonString);
    return Response.ok().entity(jsonString).build();
}