@ServerEndpoint(value="/whiteboardendpoint", encoders = {FigureEncoder.class}, decoders = {FigureDecoder.class})
public class MyWhiteboard {

    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

   @OnMessage
   public void broadcastFigure(Figure figure, Session session) throws IOException, EncodeException {
    System.out.println("broadcastFigure: " + figure);
    for (Session peer : peers) {
        if (!peer.equals(session)) {
            peer.getBasicRemote().sendObject(figure);
        }
    }
}