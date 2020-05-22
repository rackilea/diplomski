@Component
public class ObjectMapperPostProcessor implements BeanFactoryPostProcessor {

public static final String OBJECT_MAPPER_BEAN_NAME = "persistenceObjectMapper";

@Override
public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) {
    final AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder
        .genericBeanDefinition(ObjectMapper.class, this::getCustomObjectMapper)
        .getBeanDefinition();
    // Leave Spring's default ObjectMapper (configured by JacksonAutoConfiguration)
    // as primary
    beanDefinition.setPrimary(false);
    final AutowireCandidateQualifier mapperQualifier = new AutowireCandidateQualifier(PersistenceObjectMapper.class);
    beanDefinition.addQualifier(mapperQualifier);
    ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition(OBJECT_MAPPER_BEAN_NAME, beanDefinition);
}

private ObjectMapper getCustomObjectMapper() {
    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategy.SnakeCaseStrategy());
    return objectMapper;
}
}