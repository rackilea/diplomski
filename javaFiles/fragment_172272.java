@GET
@Path("/foos")
@Produces("application/json")
public Response getFoos() {
    // get all Foos
    List<Foo> foos = ...;
    return Response.ok(foos).build();
}

@GET
@Path("/foos/{id}")
@Produces("application/json")
public Response getSingleFoo(@PathParam("id") String id) {
    // get the Foo
    Foo foo = ...;
    return Response.ok(foo).build();
}