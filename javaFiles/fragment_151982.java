@Component
public class RestTokenProducerRoute extends RouteBuilder {

    private String refreshedToken;

    @Override
    public void configure() throws Exception {

        restConfiguration().producerComponent("http4");

        from("timer://test?period=1200000") //called every 20 mins
                    .process(
                            exchange -> exchange.getIn().setBody(
                                    new UserKeyRequest("apiuser", "password")))
                    .marshal(userKeyRequestJacksonFormat) //convert it to JSON
                    .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                    .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                    .to("http4://localhost:8085/Service/Token")
                    .unmarshal(userKeyResponseJacksonFormat)
                    .process(new Processor() {
                        public void process(Exchange exchange) throws Exception {   
                            UserKeyResponse response= exchange.getIn().getBody(
                                    UserKeyResponse.class); //get the response object
                            System.out.println(response + "========>>>>>>" +  
                                    response.getResult());
                            setRefreshedToken(response.getResult()); //store the token in some object
                        }
                    }).log("${body}");
        }

        public String getRefreshedToken() {
            return refreshedToken;
        }

        public void setRefreshedToken(String refreshedToken) {
            this.refreshedToken = refreshedToken;
        }
}