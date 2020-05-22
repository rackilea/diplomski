@Component
public class RestTokenUserOnboardRoute extends RouteBuilder  {

    private JacksonDataFormat OtherDomainUserRequestJacksonFormat = new JacksonDataFormat(
            OtherDomainUserRequest.class);
    private JacksonDataFormat OtherDomainUserResponseJacksonFormat = new JacksonDataFormat(
            OtherDomainUserResponse.class);
    @Override
    public void configure() throws Exception {

        restConfiguration().producerComponent("http4");

        //This route is subscribed to a Salesforce topic, which gets invoked when there is any new messages in the topic.
        from("salesforce:CamelTestTopic?sObjectName=MyUser__c&sObjectClass="+MyUser__c.class.getName()))
            .convertBodyTo(OtherDomainUserRequest.class)
            .marshal(OtherDomainUserRequestJacksonFormat).log("${body}")
            .setHeader(Exchange.HTTP_METHOD, constant("POST"))
            .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
            .log("The token being passed is ==> ${bean:tokenObj?method=getRefreshedToken}")
            .setHeader("Authorization", simple("${bean:tokenObj?method=getRefreshedToken}"))
            .to("http4://localhost:8085/Service/DomainUser")
            .unmarshal(OtherDomainUserResponseJacksonFormat)
            .process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                    OtherDomainUserResponse response = exchange.getIn().getBody(
                            OtherDomainUserResponse.class);
                            System.out.println(response + "==================>>>>>> " + response.getStatusCode());
                        }
            }).log("${body}");
    }
}