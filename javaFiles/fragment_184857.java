@Path("my/path")
public class MyController {
    @GET
    public void myPath(@QueryParam float x, @QueryParam float y) {
      //Your code here
    }
}