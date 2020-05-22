@Data
@Configuration
@EnableConfigurationProperties(CreditDecisionReasonsMappingProperties.
CreditDecisionReasonMappingProperties.class)
@ConfigurationProperties("credit-decision-reasons-mapping-properties")
public class CreditDecisionReasonsMappingProperties {

@Getter
private List<CreditDecisionReasonMappingProperties> creditDecisionReasonMappingProperties;

@Data
@ConfigurationProperties
public static class CreditDecisionReasonMappingProperties {
    private String reasonCode;
    private String description;
     }

 }