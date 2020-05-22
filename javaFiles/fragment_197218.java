@GET
@Produces(MediaType.TEXT_PLAIN)
@Path("/spring-rest/ex/qstring")
public String getStuffAsMapping(HttpServletRequest request) { 
    String query = request.getQueryString();
    ...
}