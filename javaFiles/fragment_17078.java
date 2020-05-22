@Primary
@Bean
public ApiListingScanner addExtraOperations(ApiDescriptionReader apiDescriptionReader, ApiModelReader apiModelReader, DocumentationPluginsManager pluginsManager)
{
    return new FormLoginOperations(apiDescriptionReader, apiModelReader, pluginsManager);
}