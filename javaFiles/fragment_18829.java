@POST
@Path("/authorize")
public Response authorize() {
    return Response.status(Response.Status.SEE_OTHER)
            .header(HttpHeaders.LOCATION, "/api/token")
            .header("X-Foo", "bar")
            .build();
}