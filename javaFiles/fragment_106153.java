@Singleton
public class MessageDTO {
  private static String text;

  public static String getText() {
    return text;
  }

  public static void setText(String text) {
    MessageDTO.text = text;
  }
}