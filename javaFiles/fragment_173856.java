@Path("services")
public interface RestService {

    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    BarResponse getBar(BarRequest barRequest);

    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    FooResponse getFoo(FooRequest fooRequest);
}