public HttpClientParamsConfigurationImpl(Resource res) {
  try(InputStream inputStream = res.getInputStream()) { 
      properties.load(inputStream);
  } catch (IOException e) {
   LOG.error("Could not find properties file");
   e.printStackTrace();
  }
}