@Path("/data")
public class Receiver {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response storeData(Data data) {
        // do something with data

        return Response.status(201).build();
    }    
}