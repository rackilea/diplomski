@JsonDeserialize(using = RankingValueDeserializer.class)
public class RankingValue  {

    private Integer adId;
    private Integer listed;
    private Integer detail;

    public RankingValue(Integer key, Integer listed, Integer detail) {
        this.adId = key;
        this.listed = listed;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "RankingValue [adId=" + adId + ", listed=" + listed
                + ", detail=" + detail + "]";
    }

}