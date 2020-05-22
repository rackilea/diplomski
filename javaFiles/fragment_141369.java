@JsonIgnoreProperties(ignoreUnknown = true)    
public  class Entry {

    private String key;
    private String value;


    public Entry() {}


    public String getKey() {
        return key;
    }


    public String getValue() {
        return value;
    }
}