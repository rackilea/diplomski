@POST
 @Path("/test")
 @Consumes(MediaType.APPLICATION_XML)
 public Response test(Book book) {
    return Response.ok(book.getName() + "123").build();
 }