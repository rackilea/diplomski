@Path("userid/{userid}/companyid/{companyid}{optparam:(/[^/]+?)*}")
public Response getLocation(
        @PathParam("userid") int userid,
        @PathParam("companyid") int companyid,
        @PathParam("optparam") String optparam) {
    String[] params = parseParams(optparam);
    ...
}

private String[] parseParams(String params) {
    if (params.startsWith("/")) {
        params = path.substring(1);
    }
    return params.split("/");
}