@Path("/treeData")
@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)
public Response storeTreeData(
        @FormParam("data") String data,
        @FormParam("username") String username,
        @FormParam("accID") String accID) {

    // Build a text/plain response from the @FormParams.
    StringBuilder sb = new StringBuilder();
    sb.append("data=").append(data)
      .append("; username=").append(username)
      .append("; accId=").append(accID);

    // Return 200 OK with text/plain response body.
    return Response.ok(sb.toString()).build();
}