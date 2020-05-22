CamelContext context = new DefaultCamelContext();
context.addRoutes(new RouteBuilder() {

  @Override
  public void configure() throws Exception {
    from("direct:test")
        .to("freemarker:classpath:/resources.fm")
        .to("file:target"); 
  }
});
context.start();

Map<String, Object> headers = new HashMap<String, Object>();
headers.put("firstName", "Claus");
//...
context.createProducerTemplate().sendBodyAndHeaders(
        "direct:test", 
        "PS: Next beer is on me, James",
        headers);