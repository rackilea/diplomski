private WireMockRule testServer;

@Rule
public WireMockRule testServer() {
    if (testServer != null) {
        return testServer;
    }
    // ... other stuff gets created ...
    testServer = new WireMockRule(
        wireMockConfig().extensions(...parameterized-extensions...).port(PORT), true);
    return testServer;
}