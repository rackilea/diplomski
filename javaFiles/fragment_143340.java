import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = "id", ignoreUnknown = true)
public class Advert {

    public Advert() {}

    @JsonProperty(value = "_id")
    public String advertId;

    @JsonProperty(value = "adgroup_id")
    public String adgroupId;

}