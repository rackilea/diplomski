import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

...

@Rule
public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().port(8888));