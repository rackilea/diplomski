public abstract class GenericComponent {
  private static final BACKGROUND_COLOR = Color.GRAY;
  private static final FOREGROUND_COLOR = Color.WHITE;
  public static void setComponent(Component comp) {
    comp.setBackgroundColor(backgroundColor);
    comp.setForegroundColor(foregroundColor);
  }

  //here provide a list of abstract methods that each extension class will implement.
}