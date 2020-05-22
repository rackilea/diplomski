public class YamlMap {

    Map<String, String> mp;

    @JsonCreator
    public YamlMap(@JsonProperty("mp") Map<String, String> mp) {
        this.mp = mp;
    }
}