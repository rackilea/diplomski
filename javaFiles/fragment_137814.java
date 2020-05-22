@Component
public class UriOrBeanDeserializerModifier extends BeanDeserializerModifier implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public BeanDeserializerBuilder updateBuilder(DeserializationConfig config, BeanDescription beanDesc,
            BeanDeserializerBuilder builder) {
        PersistentEntities entities = applicationContext.getBean(PersistentEntities.class);
        Associations associationLinks = applicationContext.getBean(Associations.class);
        ConversionService conversionService = applicationContext.getBean("defaultConversionService", ConversionService.class);
        Iterator<SettableBeanProperty> properties = builder.getProperties();
        PersistentEntity<?, ?> entity = entities.getPersistentEntity(beanDesc.getBeanClass());

        if (entity == null) {
            return builder;
        }

        while (properties.hasNext()) {

            SettableBeanProperty property = properties.next();
            PersistentProperty<?> persistentProperty = entity.getPersistentProperty(property.getName());

            if (associationLinks.isLookupType(persistentProperty) || !associationLinks.isLinkableAssociation(persistentProperty)) {
                continue;
            }

            if (property.getAnnotation(UriOrBean.class) != null) {
                UriOrBeanDeserializer deserializer = new UriOrBeanDeserializer(persistentProperty, conversionService);
                builder.addOrReplaceProperty(property.withValueDeserializer((JsonDeserializer<?>) deserializer), false);
            }
        }

        return builder;
    }
}