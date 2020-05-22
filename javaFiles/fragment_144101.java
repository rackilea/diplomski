public class Bar {
    public Response foo(String request, Exchange exchange){
        //make instance of MyObject
        MyObject myObj = new myObj();
        //do your processing and set the object in response code
        Response response = Response.status(Status.ACCEPTED).entity(myObj).type(MediaType.APPLICATION_JSON).build();
        return response;
    }
}