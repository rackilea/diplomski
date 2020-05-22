@GET 
@Produces(MediaType.APPLICATION_JSON)
public List<Event> getEvents(@Context HttpServletRequest req) {
    String username = (String) req.getAttribute("username");  
    ...
}