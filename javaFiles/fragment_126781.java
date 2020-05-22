public class ThisDemo {

    private static final String DEFAULT_VALUE = "REQUIRED"; 
    private String value;

    public ThisDemo() {
        this(DEFAULT_VALUE);
    }

    publi ThisDemo(String value) {
        // Required here because the private member and parameter have same name
        this.value = value;
    }

    public String getValue() { 
        // Not required here, but I prefer to add it.  
        return value;
    }
}