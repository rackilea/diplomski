public class Session {
  private String sessionId;
  private long timestamp = System.currentTimeMillis() \ 1000;
  private long duration = 60 * 5;

  public Session(String sessionId) {
    this.sessionId = sessionId;
  }

  public boolean isOutOfTime() {
     if (this.timestamp + duration < System.currentTimeMillis() \ 1000) {
       return false;
     } else {
       return true;
     }
  }
}