public class RequiredRepeatablePropertiesCondition extends SpringBootCondition {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequiredRepeatablePropertiesCondition.class.getName());

    public static final String[] REQUIRED_KEYS = {
            "my.services[i].version",
            "my.services[i].name"
    };

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        List<String> missingProperties = new ArrayList<>();
        RelaxedPropertyResolver resolver = new RelaxedPropertyResolver(context.getEnvironment());
        Map<String, Object> services = resolver.getSubProperties("my.services");
        if (services.size() == 0) {
            missingProperties.addAll(Arrays.asList(REQUIRED_KEYS));
            return getConditionOutcome(missingProperties);
        }
        //gather indexes to check: [0], [1], [3], etc
        Pattern p = Pattern.compile("\\[(\\d+)\\]");
        Set<String> uniqueIndexes = new HashSet<String>();
        for (String key : services.keySet()) {
            Matcher m = p.matcher(key);
            if (m.find()) {
                uniqueIndexes.add(m.group(1));
            }
        }
        //loop each index and check required props
        uniqueIndexes.forEach(index -> {
            for (String genericKey : REQUIRED_KEYS) {
                String multiServiceKey = genericKey.replace("[i]", "[" + index + "]");
                if (!resolver.containsProperty(multiServiceKey)) {
                    missingProperties.add(multiServiceKey);
                }
            }
        });
        return getConditionOutcome(missingProperties);
    }

    private ConditionOutcome getConditionOutcome(List<String> missingProperties) {
        if (missingProperties.isEmpty()) {
            return ConditionOutcome.match(ConditionMessage.forCondition(RequiredRepeatablePropertiesCondition.class.getCanonicalName())
                    .found("property", "properties")
                    .items(Arrays.asList(REQUIRED_KEYS)));
        }
        return ConditionOutcome.noMatch(
                ConditionMessage.forCondition(RequiredRepeatablePropertiesCondition.class.getCanonicalName())
            .didNotFind("property", "properties")
            .items(missingProperties)
        );
    }
}