public class BlahResource{
    @GET
    @Path("path1")
    public Response m1(){
        return Response.ok("blah").build();
    }

    @GET
    @Path("path2")
    public Response m2(){
        return this.m1();
}