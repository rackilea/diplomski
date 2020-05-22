public class SearchParams {

    @QueryParam("lon")
    private String longitude;

    @QueryParam("lat")
    private String latitute;

    @QueryParam("range")
    @DefaultValue("10000")
    private String range;

    @QueryParam("eType")
    private String eventType;

    @QueryParam("pType")
    private String placeType;

    @QueryParam("count")
    @DefaultValue("50")
    private String count;

    // Getters and setters
}