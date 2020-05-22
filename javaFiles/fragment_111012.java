@POST
@Consumes({MediaType.APPLICATION_XML})
@Produces({MediaType.TEXT_PLAIN})
@Path("/post")
public String postPerson(@Context HttpServletRequest request) throws Exception{
    ServletInputStream inputStream = request.getInputStream();
    System.out.println(inputStream.isFinished());
    byte[] buffer = new byte[250];
    int read = inputStream.read(buffer);
    System.out.println(new String(buffer, 0, read));
    // ...
}