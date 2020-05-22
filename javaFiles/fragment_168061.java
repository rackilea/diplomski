@Controller
public class SocketController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocketController.class);

    @Autowired private SimpMessagingTemplate template;

    public void sendMessage(String message) {
        LOGGER.info("====> sendMessage:");
        this.template.convertAndSend("/topic/public", message);
    }
}