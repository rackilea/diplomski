@Configuration
@ConfigurationProperties
public class MapFieldConfig {

    private Map<String,List<String>> myMap;

    public Map<String, List<String>> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, List<String>> myMap) {
        this.myMap = myMap;
    }
}