@GET
@Path("/test")
@Authenticate
public Response test(@Context HttpServletRequest request, @Context HttpServletResponse 
response) {
    Map<String, Object> model = createModel();
    if (userIsAuthenticated()) {
        return Response.status(401).build();
    } else {
        return Response.ok(new Viewable("/somePath/jspFile", model)).build();
    }
}