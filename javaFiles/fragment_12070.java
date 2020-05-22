private ClientConfig getClientConfig() {
   ClientConfig config = new DefaultClientConfig();

   config.getProperties().put(
            DefaultApacheHttpClientConfig.PROPERTY_CHUNKED_ENCODING_SIZE, 0);
   return config;
}