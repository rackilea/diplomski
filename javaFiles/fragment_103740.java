@JsonIgnoreProperties(ignoreUnknown = true)
public class GlossaryEntry {

    @JsonProperty("ID")
    private String id;

    @JsonProperty("SortAs")
    private String sortAs;

    @JsonProperty("Abbrev")
    private String abbrev;

    // Constructor, getters and setters omitted
}