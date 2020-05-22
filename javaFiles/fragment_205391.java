@Log
@SpringBootApplication
public class RedisApplication {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private LineItemRepository lineItemRepository;

    private ApplicationRunner titleRunner(String title, ApplicationRunner rr) {
        return args -> {
            log.info(title.toUpperCase() + ":");
            rr.run(args);
        };
    }

    @Bean
    ApplicationRunner geography(RedisTemplate<String, String> rt) {
        return titleRunner("geography", args -> {
            GeoOperations<String, String> geo = rt.opsForGeo();
            geo.add("Sicily", new Point(13.361389, 38.155556), "Arigento");
            geo.add("Sicily", new Point(15.087269, 37.502669), "Catania");
            geo.add("Sicily", new Point(13.583333, 37.316667), "Palermo");

            Circle circle = new Circle(new Point(13.583333, 37.316667),
                    new Distance(100, RedisGeoCommands.DistanceUnit.KILOMETERS));

            GeoResults<GeoLocation<String>> radius = geo.radius("Sicily", circle);
            radius.getContent().forEach(c -> log.info(c.toString()));
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }



    @Bean
    ApplicationRunner repositories() {
        return titleRunner("repositories", args -> {
            Long orderId = generateId();

            List<LineItem> itemsList = Arrays.asList(
                        new LineItem(orderId, generateId(), "plunger"),
                        new LineItem(orderId, generateId(), "soup"), 
                        new LineItem(orderId, generateId(), "cofee mug"));

            itemsList.stream().map(lineItemRepository::save).forEach(li -> log.info(li.toString()));

            Order order = new Order(orderId, new Date(), itemsList);
            orderRepository.save(order);

            Collection<Order> found = orderRepository.findByWhen(order.getWhen());
            found.forEach(o -> log.info("found : " + o.toString()));
        });
    }

    private Long generateId() {
        long tmp = new Random().nextLong();
        return Math.max(tmp, tmp * -1);
    }
}