import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

...

WireMockServer wm = new WireMockServer(options().port(8888));

wm.stubFor(...)