@Configuration
public class MyConfig {

    @Value("${com.mycompany.propertygroup.propertyname:}")
    private String newValue;

    @Value("${oldconvention.propertyname:}")
    private String oldValue;

    public String getValue() {

        if (newValue != null && !newValue.isEmpty()) {
            // New value is provided
            System.out.println("New Value: " + newValue);
            return newValue;
        }
        else {
            // Default to the old value
            return oldValue;
       }
    }
}