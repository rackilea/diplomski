public static class MyClientConfigurator extends ClientEndpointConfig.Configurator {
    static volatile boolean called = false;

    @Override
    public void beforeRequest(Map<String, List<String>> headers) {
        called = true;
        headers.put(HEADER_NAME, Arrays.asList(HEADER_VALUE));
        headers.put("Origin", Arrays.asList("myOrigin"));
    }

    @Override
    public void afterResponse(HandshakeResponse handshakeResponse) {
        final Map<String, List<String>> headers = handshakeResponse.getHeaders();

        assertEquals(HEADER_VALUE[0], headers.get(HEADER_NAME).get(0));
        assertEquals(HEADER_VALUE[1], headers.get(HEADER_NAME).get(1));
        assertEquals(HEADER_VALUE[2], headers.get(HEADER_NAME).get(2));
        assertEquals("myOrigin", headers.get("origin").get(0));
    }
}