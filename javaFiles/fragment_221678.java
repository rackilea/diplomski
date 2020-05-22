@Bean
public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory,
                       MongoMappingContext context, BeanFactory beanFactory)
{
    context.setInitialEntitySet(new HashSet<>(Arrays.asList(Person.class, Animal.class,
            Program.class)));
    context.initialize();

    DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
    MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);

    try {
        mappingConverter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
    } catch (NoSuchBeanDefinitionException ignored) {} // Swallow error

    return mappingConverter;
}

@Bean
public MongoProperties mongoProperties() {
    // not exactly sure which property should I return
    return this.mongoProperties.getSecondary();
}