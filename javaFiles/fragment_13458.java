@RestController
public class MyRestController {

    @Autowired
    private MailService mailService;
    @Autowired
    private Environment environment;  

    @PostMapping("/orders")
    public void createOrders(@RequestBody List<Order> orders) {
        // manipulations with orders
        if (environment.acceptsProfiles(Profiles.of("mail"))) {
            mailService.send("Order notification", "New orders", "1@mail.com");
        }
    }
}