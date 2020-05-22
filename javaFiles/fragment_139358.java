@PropertySource(value = "classpath:myapp.properties")
@Component
class MySettings {
    @Value("${prefix.int-field}")
    private int intField;

    @Value("${prefix.string-field}")
    private String stringField;

    @Value("${prefix.custom-type-field}")
    private String customFieldType;

    private CustomInterface customField;

    @PostConstruct
    public void init() {
        customField = (CustomInterface) Class.forName(customFieldType).newInstance(); // short form... will need checks that it finds the class and can create a new instance
    }
}

class CustomType implements CustomInterface {...}

interface CustomInterface {...}