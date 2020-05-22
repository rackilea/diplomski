@POST
@Consumes("multipart/form-data")
@Produces("application/json")
public String post(
        @FormDataParam("name") String name,
        @FormDataParam("description") String description,
        @FormDataParam("iconfile") FormDataBodyPart part,
        @Context HttpServletRequest hsr) {
    // ...
}