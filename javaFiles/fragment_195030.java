@Component
public class SendWebSocketUpdates
{
    private static final Logger logger = LoggerFactory.getLogger(SendWebSocketUpdates.class);

    private final Gson gson;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessageBrokerConsumer<String> messageBrokerConsumer;

    public SendWebSocketUpdates()
    {
        this.gson = new Gson();
    }

    @PostConstruct
    public void init()
    {
        //listen for incoming AMQP messages from the rabbitmq server and forward them to the websocket subscribers
        messageBrokerConsumer.addListener((message, topicName) -> {
            final String destination = "/topic/" + topicName;
            final String messageJson = gson.toJson(message.getBody());

            //check to see if trace logging is enabled
            if (logger.isTraceEnabled())
            {
                logger.trace("Sending Message to \"{}\": {}", destination, messageJson);
            }

            //broadcast the via a STOMP message to subscribers of this topic
            messagingTemplate.convertAndSend(destination, messageJson);
        });
    }
}