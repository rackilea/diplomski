@Configuration
@PropertySources({
    @PropertySource("default.properties"),
    @PropertySource(value = "file:${CONF_DIR}/optional-override.properties", ignoreResourceNotFound = true)
}
public class ApplicationConfig {
}