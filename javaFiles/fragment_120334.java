public static void main(String[] args) {
    JndiContext jndiContext = (new SetJndiContext()).SetJndiContext();
    CamelContext camelContext = new DefaultCamelContext(jndiContext);
    try {
         //camelContext.addRoutes(new MyRouteBuilder());
         camelContext.addRoutes(new FileDownloadRouter());
         camelContext.start();
         Thread.sleep(10000);
         camelContext.stop();
     } catch (Exception e) {
         e.printStackTrace();
     }
}