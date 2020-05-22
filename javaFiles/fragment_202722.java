@GET
    @Path("/getProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@QueryParam("id") long id) {
        Product prod = null;
        for (Product p : products) {
            if (p.getId() == id)
                prod = p;
        }
        return prod;
    }