public class RequestGenerator 
{

    private WebTarget target;
    private ClientConfig config;
    private Client client;
    private Response response;

    public RequestGenerator(Method RequestSendingMethod) throws Exception
    {
               switch (RequestSendingMethod)
            {
                case POST :             
                    String payload = "\r\n{\r\n\"query\": \"google \",\r\n\"rows\": 50,\r\n\"return_docs\": true,\r\n\"is_facet\": true\r\n}"; //this is escapped json string in single line
                    config = new ClientConfig();
                    client = ClientBuilder.newClient(config);
                    target = client.target("http://localhost:7400/searchws/search/getresults");
                    response = target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(payload, MediaType.APPLICATION_JSON), Response.class);
                    processresponse(response); //This could be any method which processes your json response and gets you your desired data.
                    System.out.println(response.readEntity(String.class));
                    break;
                case GET :
                    config = new ClientConfig();
                    client = ClientBuilder.newClient(config);
                    target = client.target("http://localhost:7400/search-service/searchservice").path("search").path("results").path("tiger");
                    response = target.request().accept(MediaType.APPLICATION_JSON).get();
                    processresponse(response); //This could be any method which processes your json response and gets you your desired data.
                    System.out.println(response.readEntity(String.class));
            }

}