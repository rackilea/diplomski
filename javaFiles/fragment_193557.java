public class CoinDeskResponse {
    private TimeInfo time;
    private String disclaimer;
    private BpiInfo bpi;
    //general getters and setters
}

class TimeInfo {
    private String updated;
    private String updatedISO;
    //general getters and setters
}

class BpiInfo {
    private String code;
    private String symbol;
    private String rate;
    private String description;

    @JsonProperty("rate_float")
    private String rateFloat;
    //general getters and setters
}