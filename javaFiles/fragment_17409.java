@GET
    @Path("/test")
    @Produces(value = MediaType.TEXT_HTML)
    public String test() {
        return "<script>alert('test');</script>";
    }