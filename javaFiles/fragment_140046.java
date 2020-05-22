@Bean
@Override
public AlpsJsonHttpMessageConverter alpsJsonHttpMessageConverter() {
    return new CustomAlpsJsonHttpMessageConverter(alpsConverter());
}

@Bean
@Override
public RootResourceInformationToAlpsDescriptorConverter alpsConverter() {
    Repositories repositories = repositories();
    PersistentEntities persistentEntities = persistentEntities();
    RepositoryEntityLinks entityLinks = entityLinks();
    MessageSourceAccessor messageSourceAccessor = resourceDescriptionMessageSourceAccessor();
    RepositoryRestConfiguration config = config();
    ResourceMappings resourceMappings = resourceMappings();

    return new CustomRootResourceInformationToAlpsDescriptorConverter(associationLinks(), repositories, persistentEntities,
            entityLinks, messageSourceAccessor, config, objectMapper(), enumTranslator());
}