@Controller
public class MyController {


    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chats")
    public void handleChat(@Payload ChatMessage message) {
        this.simpMessagingTemplate.convertAndSend("/queue/chats-" + "mycustomidentifier", "[" + getTimestamp() + "]:" + message.getMessage());
    }
....