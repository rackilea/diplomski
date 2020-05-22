@Configuration
    public class TestMongoInterface
    {
        @Autowired
        private OrderRepository orderRepository;
        @Autowired
        public void canReadOrders()
        {
            List<Order> orders = orderRepository.findAll();
            for(Order o : orders)
                System.out.println("found: "+o.toString());
        }
    }