@GET
@Path("player/{gender}")
@Produces("application/json")
public Whatever myMethod(@PathParam("gender") final String gender) {
  // your implementation here
}

@GET
@Path("player")
@Produces("application/json")
public Whatever myMethod() {
  return myMethod(null);
}