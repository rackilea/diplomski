@GET
@Path("{id}")
public Foo get(@PathParam("id") Integer id,
               @Valid @NotNull @QueryParam("param1") Integer param1) {
....
}