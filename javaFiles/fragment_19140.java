@Test
public void test() throws Exception{
   //mock input route (replace quartz with direct)
   context.getRouteDefinitions().get(0).adviceWith(context, new AdviceWithRouteBuilder() {
       @Override
       public void configure() throws Exception {
           replaceFromWith("direct:triggerQuartz");
       }
   });

   //trigger endpoint
   sendBody("direct:triggerQuartz", null);

   //do some assertions
}