package webapp;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
@Produces("text/plain")
public class Resource {

   @GET
   public String hello() {
       return "hello";
   }


   @GET
   @Path("/books")
   public String getBooks() {
       return "books";
   }

   @GET
   @Path("/book/{isbn}")
   public String getBook(@PathParam("isbn") String id) {
       return "11123";
   }
}