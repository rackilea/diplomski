@JsonIgnoreProperties(ignoreUnknown = true)
public class Response{

 @JsonProperty("data")
 List<Planeta> data;

 }