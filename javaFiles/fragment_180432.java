@Override
protected RouteBuilder createRouteBuilder() throws Exception {
    return new RouteBuilder() {
        @Override
        public void configure() throws Exception {

            from("direct:route1")
                .bean(new HttpBean())
                .filter(property("IP").isNull()).setFaultBody(constant("Ip is missing")).end()
                .to("mock:mock");
        }
    };
}

public static class HttpBean {
    public void parseIP(@Properties Map properties, @XPath("//ip") String ip){
        if(ip != null && ip.length() > 0){
            properties.put("IP", ip);
        }
    }
}