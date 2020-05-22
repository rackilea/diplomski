@WebSocket
public class ServerSide {
  @OnOpen
  public void onOpen(Session session) throws IOException {
    System.out.println("Welcome" + new Date());
    session.getBasicRemote().sendText("Hello websockets");  
  }
}