public class Bean {
    @QueryParam("blah")
    String blah;
}

@GET
public Response get(@BeanParam Bean bean) {}