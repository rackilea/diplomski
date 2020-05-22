@Controller
public class TestSocketController
{
    private SimpMessagingTemplate template;

    @Autowired
    public TestSocketController(SimpMessagingTemplate template)
    {
        this.template = template;
    }

    void setResults(String ret, String sessionId)
    {
        template.convertAndSend("/topic/testwsresponse/" + sessionId, ret);
    }

    @MessageMapping(value="/testws/{sessionId}")
    public void handleTestWS(@DestinationVariable String sessionId, @Payload String msg) throws InterruptedException
    {
        (new Thread(new Later(this, sessionId))).start();
        setResults("Testing Return", sessionId);
    }

    public class Later implements Runnable
    {
        TestSocketController Controller;
        String sessionId;
        public Later(TestSocketController controller, String sessionId)
        {
            Controller = controller;
            this.sessionId = sessionId;
        }

        public void run()
        {
            try
            {
                java.lang.Thread.sleep(2000);

                Controller.setResults("Testing Later Return", sessionId);
            }
            catch (Exception e)
            {
            }
        }
    }
}