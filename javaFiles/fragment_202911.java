@Path("/calc")
public class Calculator {
    @Context
    HttpServletRequest request;
    //Define the server api to be able to perform server operations
    WLServerAPI api = WLServerAPIProvider.getWLServerAPI();
    @GET
    @Path("/addTwoIntegers/{first}/{second}")
    public String addTwoIntegers(@PathParam("first") String first, @PathParam("second") String second){
        int a=Integer.parseInt(first);
        int b=Integer.parseInt(second);
        int c=a+b;
       return Integer.toString(c);
    }
}