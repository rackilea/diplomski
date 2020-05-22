@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/hello")
    public void greeting(Principal principal, HelloMessage message) throws  Exception {
        Greeting greeting = new Greeting();
        greeting.setContent("Hello!");
        messagingTemplate.convertAndSendToUser(message.getToUser(), "/queue/reply", greeting);
    }
}