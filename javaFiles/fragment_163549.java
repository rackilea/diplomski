@Bean
public CamelContextConfiguration camelConfig() {
    return new CamelContextConfiguration() {
        @Override
        public void beforeApplicationStart(CamelContext context) {

            context.setInflightRepository(new MyCustomInflightRepository(/* Dependencies go here */ ));
        }

        @Override
        public void afterApplicationStart(CamelContext camelContext) {

        }
    };
}