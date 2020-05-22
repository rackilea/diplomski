@Service("smsService")
public class AltiriaSMSRestServiceImpl implements SmsService {

    private final SmsConfigData smsConfig;

    public AltiriaSMSRestServiceImpl(SmsConfigData smsConfig) {
        this.smsConfig = smsConfig;
    }
    ...
}

// the configuration data, mapped to the application.properties/yml file
@ConfigurationProperties(prefix="sms")
@Data
public class SmsConfigData {

    @Value("${domainId}")
    private String domainId;
    ...
}

// this is a spring configuration class, ie the definition of spring beans
// I don't think you even need this, since the 
// SmsConfigData gets constructor-injected automatically
// this is the class that gets included in the test config class list

@Configuration
public class SmsServiceConfiguration {
@Bean
SmsService smsService(SmsConfigData config) {
    return new AltiriaSMSRestServiceImpl(config);
}