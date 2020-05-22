@POST
@Path("no-content-type")
public Bean[] post2(@FormDataParam("beans") FormDataBodyPart bodyPart) throws IOException {
    bodyPart.setMediaType(MediaType.APPLICATION_JSON_TYPE);
    Bean[] beans = bodyPart.getEntityAs(Bean[].class);
    return beans;
}