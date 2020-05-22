@Path("/fizz")
public class FizzResource {

    @POST
    @Consumes("application/json")
    public Response postFizz(Fizz fizz) {
        System.out.println("==== Created Fizz ===");
        System.out.println(fizz);
        System.out.println("=====================");
        return Response.created(null).build();
    }

    @GET
    @Produces("application/json")
    public Response getFizz() {
        Fizz fizz = new Fizz(1, "fizz");
        return Response.ok(fizz).build();
    }
}