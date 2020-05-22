public static void main(String[] args) throws IOException {

        Parent  p = new Parent();
        Header h = new Header();
        h.setUser("XXX");
        h.setPassword("af962d0ceacdd9af");
        h.setTable("licf");
        h.setMethod_override("get");
        p.setHeader(h);

        Test t = new Test();
        String jsonInString = t.writeJSON(p);

         ClientConfig config = new DefaultClientConfig();
         Client client = Client.create(config);
            client.addFilter(new LoggingFilter());
            WebResource service = client.resource("https://hostedactivation.com/XXXXX/XXXXXXXX.php");

            ClientResponse client_response = service.type(MediaType.APPLICATION_JSON).
                    header("Authorization", "Basic Y3liZXJzcGFI3UGc5").
                    post(ClientResponse.class,jsonInString);

            System.out.println("Status: "+client_response.getEntity(String.class));

            client.destroy();
}
    private String writeJSON(Parent p) throws JsonGenerationException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();   
        String jsonInString = mapper.writeValueAsString(p);
        return  jsonInString;
       }