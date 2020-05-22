@Autowired
SimpMessagingTemplate template

@Scheduled(fixedDelay = 20000L)
@SendTo("/topic/pingpong")
public void sendPong() {
   template.convertAndSend("/topic/pingpong", "pong (periodic)")
}