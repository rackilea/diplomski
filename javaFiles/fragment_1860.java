@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Component
  public static class ParallelProcessingRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
      from("seda:test?concurrentConsumers=5")
          .routeId("parallel")
          .log("Received ${body}, processing")
          .delay(5000)
          .log("Processed ${body}")
          .stop();

      from("timer:testStarter?delay=3000&period=300000")
          .routeId("test timer")
          .process(exchange -> {
            // messages we want to track
            List<Integer> toSend = IntStream.range(0, 5).boxed().collect(toList());

            NotifyBuilder builder = new NotifyBuilder(getContext())
                .fromRoute("parallel")
                .filter(e -> toSend.contains(e.getIn().getBody(Integer.class)))
                .whenDone(toSend.size())
                .create();

            ProducerTemplate template = getContext().createProducerTemplate();

            // messages we do not want to track
            IntStream.range(10, 15)
                .forEach(body -> template.sendBody("seda:test", body)); 

            toSend.forEach(body -> template.sendBody("seda:test", body)); 

            exchange.getIn().setBody(builder.matches(1, TimeUnit.MINUTES));
          })
          .log("Matched? ${body}");
    }
  }
}