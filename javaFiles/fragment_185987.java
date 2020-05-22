public class CampaignDTO {
    private String name;
    private BigDecimal budget;
    private Integer type;
    private Boolean dynamic;

    @JsonProperty("geo_target")
    private List<Integer> geoTarget;

    @JsonProperty("time_target")
    private TimeTarget timeTarget;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getDynamic() {
        return dynamic;
    }

    public void setDynamic(Boolean dynamic) {
        this.dynamic = dynamic;
    }

    public List<Integer> getGeoTarget() {
        return geoTarget;
    }

    public void setGeoTarget(List<Integer> geoTarget) {
        this.geoTarget = geoTarget;
    }

    public TimeTarget getTimeTarget() {
        return timeTarget;
    }

    public void setTimeTarget(TimeTarget timeTarget) {
        this.timeTarget = timeTarget;
    }
}