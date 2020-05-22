@Path("/example")
public class ExampleResource {

    public ExampleResource(@Context CostlyService costlyService) {
        // use it here
    }

    // ...
}