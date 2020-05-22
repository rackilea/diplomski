@GET
@Path("/img3")
@Produces("image/jpg")
public Response getFile(@PathParam("id") String id) throws SQLException
{

    File file = new File("img/3.jpg");
    return Response.ok(file, "image/jpg").header("Inline", "filename=\"" + file.getName() + "\"")
            .build();
}