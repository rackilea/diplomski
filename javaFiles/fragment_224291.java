public class MyConfigImpl implements MyConfig, ManagedService {

    // This is just the property keys 
    private final static String COLORS = "my.valid.colors";
    private final static String PROP1 = "my.property.1";
    private final static String PROP2 = "my.property.2";
    private final static String PROP3 = "my.property.3";

    // For validating against some properties
    private List<String> colors = new ArrayList<>();

    // For extracting a subset of properties
    private String prop1;
    private String prop2;
    private String prop3;

    // The whole set os properties published as Dictionary (could be transformed in Map as well)
    private Dictionary props;

    @Override // Implements MyConfig.isValidColor(String color)
    public Boolean isValidColor(String color) {
        if (colors.contains(color)) {
            return true;
        } else {
            return false;
        }
    }

    @Override // Implements MyConfig.getPropertyOne()
    public String getPropertyOne(){
        return prop1;
    }

    @Override // Implements MyConfig.getPropertyTwo()
    public String getPropertyTwo(){
        return prop2;
    }

    @Override // Implements MyConfig.getPropertyThree()
    public String getPropertyThree(){
        return prop3;
    }

    @Override // Implements MyConfig.getProperties()
    public Dictionary getProperties(){
        return props;
    }


    // This implements the ManagedService.updated()
    @Override 
    public void updated(@SuppressWarnings("rawtypes") Dictionary properties) throws ConfigurationException {

        log.debug("Reading properties: {}", properties);
        if (properties == null) {
            return;
        }

        updateConfiguration(properties);

    }

    private void updateConfiguration(Dictionary properties) {

        // MyUtil.asListOfString is just a helper to convert comma separated string to list of String
        // This is just an example
        this.colors = MyUtil.asListOfStrings((String) properties.get(COLORS));

        this.prop1 = properties.get(PROP1);
        this.prop2 = properties.get(PROP2);
        this.prop3 = properties.get(PROP3);
        this.props = properties;
    }
}