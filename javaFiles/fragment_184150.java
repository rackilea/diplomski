@Autowired
FooDeserializer fooDeserializer;

@Bean
public RouteBuilder route() {
    return new RouteBuilder() {
        public void configure() {
            from("direct:marshal")
                    .bean(fooDeserializer)
                    .to("mock:marshaled");
        }
    };
}