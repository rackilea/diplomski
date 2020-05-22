public Response consult() {
    Gson gson = new GsonBuilder()
        .serializeNulls()
        .create();
    Person person = new Person();
    person.setName("Pedro");
    return Response.status(Status.OK).entity(gson.toJson(person)).build();
}