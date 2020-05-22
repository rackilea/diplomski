public static void main(String[] args) throws Exception {
  Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("YOUR PROXY IP", 80));   
HttpTransport transport = new NetHttpTransport.Builder().setProxy(proxy).build();
JsonFactory jsonFactory = new GsonFactory();
// This request initializer will ensure the API key is sent with every HTTP request.
MapsEngineRequestInitializer apiKeyInitializer =
    new MapsEngineRequestInitializer(PUBLIC_API_KEY);
}