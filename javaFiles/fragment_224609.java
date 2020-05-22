@Controller
public class SomeController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedDelay = 1000)
    private void send() {
        simpMessagingTemplate.convertAndSend("/topic/updateService", "Hello");
    }
}