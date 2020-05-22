@Controller
public class WebSocketController {
   @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/processrequest")
    void runWebSocket( RequestData requestData ) {
        new Thread(new RunProcess(requestData)).start();
    }

    private class RunProcess implements Runnable {
        private RequestData requestData;

        RunProcess(RequestData requestData) {
            this.requestData = requestData;
        }

        public void run() {
            simpMessagingTemplate.convertAndSend("/topic/response", requestData.getString1());
            simpMessagingTemplate.convertAndSend("/topic/response", requestData.getString2());
            simpMessagingTemplate.convertAndSend("/topic/response", "A third response via websocket");
        }
    }
}