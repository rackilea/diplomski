@Component
public class MyEndpoint extends Endpoint {

    @Autowired
    MyService myService;

    @Override
    public void onOpen(Session session, EndpointConfig config) {

        session.addMessageHandler(new MyMessageHandler(session));
    }


    class MyMessageHandler implements MessageHandler.Whole<String> {

        final Session session;

        public MyMessageHandler(Session session) {
            this.session = session;
        }

        @Override
        public void onMessage(String message) {
            try {
                String greeting = myService.getGreeting();
                session.getBasicRemote().sendText(greeting + ", got your message (" + message + "). Thanks ! (session: " + session.getId() + ")");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}