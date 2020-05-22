public class Commonage {

    @JsonProperty("commonage_id")
    private String commonageIdentifier;

    @JsonProperty("gross_area")
    private double grossArea;

    @JsonProperty("max_elig")
    private double maxEligibleArea;

    @JsonProperty("min_stock")
    private int minStock;

    @JsonProperty("max_stock")
    private int maxStock;

    @JsonProperty("start_date")
    private Date startDate;

    @JsonProperty("end_date")
    private Date endDate;

    @JsonProperty("owner_share")
    private String ownerShare;

    @JsonProperty("type")
    private String type;

    @JsonProperty("townland")
    private String townland;

    @JsonProperty("comment")
    private String comment;
}