@POST
@Path("/temp/{abc}")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
// NOTE THE CHANGE OF RESULT TYPE
public UserInfo createUser2(List<User> users,@PathParam("abc") String abc) {
    //.................//
    List<Long> listLong=new ArrayList<Long>();
    listLong.add(1L);
    listLong.add(2L);
    System.out.println("temp called");
    return new UserInfo(listLong); // <<<< THIS LINE CHANGED TOO
}