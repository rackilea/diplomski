class Customer {
    @QueryParam("name")
    private String name;
    @QueryParam("id")
    private int id;
    // getters/setters
}

@GET
public Response get(@BeanParam Customer customer)