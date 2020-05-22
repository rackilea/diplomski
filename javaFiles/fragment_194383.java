@Path("foo")
public class MyResource {

    @GET
    public String searchCount(@QueryParam("lon") String longitude,
                              @QueryParam("lat") String latitute,
                              @QueryParam("range") @DefaultValue("10000") String range,
                              @QueryParam("eType") String eventType,
                              @QueryParam("pType") String placeType,
                              @QueryParam("count") @DefaultValue("50") String count) {
        ...
    }
}