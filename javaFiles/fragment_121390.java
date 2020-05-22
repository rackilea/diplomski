HTTPConduitConfigurer httpConduitConfigurer = new HTTPConduitConfigurer() {
    public void configure(String name, String address, HTTPConduit c) {
        c.setTlsClientParameters(_tlsParams);
    }
}
bus.setExtension(httpConduitConfigurer, HTTPConduitConfigurer.class);