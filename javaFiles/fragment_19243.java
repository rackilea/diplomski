public class WufooIntegrationRoutingSlip {

    @RoutingSlip
    public String slip(String body) {
        String answer = "activemq:noProducerDefined";
        ProviderTypeWrangler wrangler = new ProviderTypeWrangler();
        String producer = wrangler.getProvider(body);
        Logger mylogger = Logger.getLogger("log4j.logger.org.apache.camel");
        if (!producer.equals("")) {
            mylogger.info("Body:"+body);
            answer = "activemq:"+producer;
        }
        return answer;
    }

}