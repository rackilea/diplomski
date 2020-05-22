private Session session;

public Game(Session session, int width, int height) {
    this.session = session;
    this.WIDTH = width;
    this.HEIGHT = height;
}


private void sendMessage(String text) {
    try {
        session.getBasicRemote().sendText(text);
    } catch (IOException e) {
        e.printStackTrace();
    }
}