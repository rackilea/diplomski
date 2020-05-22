@GET
    @Path("/getCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@QueryParam("id") long id) {
        Customer cli = null;
        for (Customer c : customers) {
            if (c.getId() == id)
                cli = c;
        }
        return cli;
    }