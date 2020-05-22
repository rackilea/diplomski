@JsonIgnoreProperties(ignoreUnknown = true)  
public class Attributes {

    public Attributes() {}

    private ArrayList<Entry> entry;  

    public ArrayList<Entry> getEntry() {
        return entry;
    }    
}