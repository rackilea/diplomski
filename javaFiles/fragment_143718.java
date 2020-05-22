@GET
public Response getCookie() {
    NewCookie cookie = new NewCookie("Name", "Value", "path", "domain",
                                     "comment", 300, true, true);
    ResponseBuilder builder = Response.ok("Cool Stuff");
    builder.cookie(cookie);
    return builder.build();
}