@SpringBootApplication
public class SocamelApplication extends RouteBuilder implements ApplicationRunner {
    @Autowired
    private FooProcessor fooProcessor;

    public static void main(String[] args) {
        SpringApplication.run(SocamelApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Thread.sleep(5000);
    }

    @Override
    public void configure() throws Exception {
        from("timer://foo?period=100&repeatCount=1").setBody()
                                                    .constant(Arrays.asList("Hello", "World"))
                                                    .log("1 >>> ${body} ")
                                                    .split(body())
                                                    .log("2 >>> ${body}")
                                                    .bean(fooProcessor)
                                                    .log("3 >>> ${body}")
                                                    .end()
                                                    .log("4 >>> ${body}");

    }

    @Bean
    public FooProcessor fooProcessor() {
        return new FooProcessor();
    }

}

class FooProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String reverseMe = exchange.getIn()
                                   .getBody(String.class);

        String reversed = new StringBuilder(reverseMe).reverse()
                                                      .toString();

        exchange.getOut()
                .setBody(reversed);
    }

}