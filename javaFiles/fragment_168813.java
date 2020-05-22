public Response getAllUsers() {
    RestBean restBean = GetAllUsers();
    Boolean isRegistered = true;
    final ComplexResult result = new ComplexResult(bean, isRegistered);

    return Response.ok().entity(Entity.json(result)).build();
}