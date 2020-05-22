@Autowired
private OrderHandler orderHandler;  // only change

@Bean
public ResourceProcessor<Resource<Order>> orderResourceProcessor() {
    return new ResourceProcessor<Resource<Order>>() {


        @Override
        public Resource<Order> process(Resource<Order> resource) {
            Order order = resource.getContent();
            Payment payment = orderHandler.payment(order);

            resource.add(makeLink(payment));

            return resource;
        }

        private Link makelink(Payment payment) {
            return new Link(/*...*/);
        }
    };
}