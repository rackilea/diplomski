public class HelloWorldClient {

    public static void main(String[] args) {
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(getRestUrl());
            ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            String output = response.getEntity(String.class);
            System.out.println("\nOutput from Server.... " + output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getRestUrl() throws IOException {
        Properties prop = GenericUtils.loadProperties("application.properties");
        String restUri = prop.getProperty("rest.uri");
        System.out.println("restUri = " + restUri);
        return restUri;
    }

}