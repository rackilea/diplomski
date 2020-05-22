@EnableScheduling
@SpringBootApplication
public class JpaDemoApplication {

    @Autowired
    ItemRepository itemrepo;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Scheduled(fixedRate=100000)
    public void run() {
        Item item = new Item();
        item.setValue("ABC");
        itemrepo.save(item); // Item instance, not String
        System.out.println(itemrepo.count());
    }

}