@JsonIgnoreProperties(ignoreUnknown = true)
public class WrapperObject { // we can give any name to class, its only external {}    

    private Attributes attributes;

    public WrapperObject() {}

    public Attributes getAttributes() {
        return attributes;
    }    
}