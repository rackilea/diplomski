public class EchoResponseMessage {
  private final String message;

  public EchoResponseMessage(String message) {
    this.message = message;
  }

  public Buffer toBuffer() {
    // Serialize;
  }
}