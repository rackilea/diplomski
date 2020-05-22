@Component
public class SomeBean {

    @Autowired
    private OrderRepository orderRepository;

    @PostConstruct
    public void init() {

        Date date = new Date();

        Order order = new Order();
        order.setId(1L);
        order.setCreation(date);

        orderRepository.save(order);

        Date creationFromDB = orderRepository.findOne(1L).getCreation();

        System.out.println("eq? : "+ new Date(creationFromDB.getTime()).equals(order.getCreation()));
        List<Order> ods = orderRepository.findByCreation(creationFromDB);
        List<Order> ods2 = orderRepository.findByCreation2(creationFromDB);
        System.out.println("\n ods.size: " + ods.size() +", ods2.size: "+ods2.size());

    }
}