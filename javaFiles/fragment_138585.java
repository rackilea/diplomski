public class EchoRequestMessage {
  private String message;

  public static EchoRequestMessage fromBuffer(Buffer buffer) {
    // Deserialize
  }

  public String getMessage() {
    return message;
   }
 }