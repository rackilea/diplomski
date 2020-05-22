@ServerEndpoint("/rafflethis")
public class RaffleThis implements Serializable {

  private static final Logger LOGGER = Logger.getLogger(RaffleThis.class.getName());
  private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
  @Inject
  MessageDTO messageDTO;

  private static void sendMessageToAll(String message) {
    for (Session s : sessions) {
      try {
        s.getBasicRemote().sendText(message);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  @OnOpen
  public void monitorLuckyDip(Session session) throws Exception {
    sessions.add(session);
    while (true) {
      Thread.sleep(200);
      sendMessageToAll(messageDTO.getText());
    }
  }
}