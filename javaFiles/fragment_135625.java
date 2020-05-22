@Path("/animals")
class AnimalResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("dog")
    public Dog getDog(){
      return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cat")
    public Cat getCat(){
       return null;
    }
}