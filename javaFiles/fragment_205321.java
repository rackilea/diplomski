@Path("/foo")
public class FooBar {

    @GET
    @Path("/bar")
    @Produces("application/json")
    public Object testMethod(@HeaderParam("var_1") @DefaultValue("") String var1,
                             @HeaderParam("var_2") @DefaultValue("") String var2 {

        if (var1.equals(var2)) {
            return "All Good";
        } else {
            throw new WebApplicationException(HttpURLConnection.HTTP_FORBIDDEN);
        }
    }
}