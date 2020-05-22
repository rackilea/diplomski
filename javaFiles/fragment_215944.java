@GET
@Path("/property/{uuid}")
public Response getMatrix(@PathParam("uuid") PathSegment pathSegment) {
    StringBuilder builder = new StringBuilder();

    // Get the {uuid} value
    System.out.println("Path: " + pathSegment.getPath());

    MultivaluedMap matrix = pathSegment.getMatrixParameters();
    for (Object key : matrix.keySet()) {
        builder.append(key).append(":")
               .append(matrix.getFirst(key)).append("\n");
    }
    return Response.ok(builder.toString()).build();
}