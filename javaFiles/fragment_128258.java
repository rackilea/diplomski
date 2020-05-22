import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "start_time",
    "end_time",
    "value"
})
public class Datum {

    @JsonProperty("start_time")
    public String startTime;
    @JsonProperty("end_time")
    public String endTime;
    @JsonProperty("value")
    public Double value;

}


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "space_id",
    "channel_id",
    "aggregation_type",
    "pids_count",
    "timezone"
})
public class Meta {

    @JsonProperty("space_id")
    public String spaceId;
    @JsonProperty("channel_id")
    public Integer channelId;
    @JsonProperty("aggregation_type")
    public String aggregationType;
    @JsonProperty("pids_count")
    public Integer pidsCount;
    @JsonProperty("timezone")
    public String timezone;

}