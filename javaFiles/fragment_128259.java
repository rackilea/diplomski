import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "message",
    "data",
    "meta"
})
public class ExampleStack {

    @JsonProperty("code")
    public Integer code;
    @JsonProperty("message")
    public String message;
    @JsonProperty("data")
    public List<Datum> data = null;
    @JsonProperty("meta")
    public Meta meta;

}