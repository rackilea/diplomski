public class Whatever{
    Map<String,String> keyvalues = new TreeMap<String,String>();
    @JsonProperty
    Map<String,String> visibility = new TreeMap<String,String>();

    @JsonAnyGetter
    public Map<String, String> getKeyvalues() {
        return keyvalues;
    }
}