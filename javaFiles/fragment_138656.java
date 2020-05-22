public class MulticastRouteTest extends CamelTestSupport {
  @Test
    public void testMulticastRoute() throws Exception {
        context.addRoutes(new MulticastRoute());
        template.sendBody("direct:multicast", null);
    }
}