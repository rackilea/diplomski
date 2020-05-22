@Configuration
@Import({ RibbonCommandFactoryConfiguration.RestClientRibbonConfiguration.class,
        RibbonCommandFactoryConfiguration.OkHttpRibbonConfiguration.class,
        RibbonCommandFactoryConfiguration.HttpClientRibbonConfiguration.class,
        HttpClientConfiguration.class })
@ConditionalOnBean(ZuulProxyMarkerConfiguration.Marker.class)
public class ZuulProxyAutoConfiguration extends ZuulServerAutoConfiguration { ... }