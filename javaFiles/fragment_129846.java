public class ResponsePOJO {
    private long timestamp; 
    private String base;
    private String date;
    private List<RatePOJO> rates;

    //getters and setters
}

public class RatePOJO {
    private String cityTag;
    private Float rate;
}