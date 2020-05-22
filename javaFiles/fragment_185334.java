@Path("/groups")
public class Grouper {

    @Path("/adoptable")
    public AdoptableAnimalsResource animalSubResource() {
        return new AdoptableAnimalsResource();
    }

    public class AdoptableAnimalsResource {

        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public String get() {
            return "dogs";
        }
    }
}