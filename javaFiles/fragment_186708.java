@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        System.out.println("rest called: " + executorService);
        return "hello ";
    }