public class WrongThreadSafety {
  private static String s;
  public synchronized String setString(String s) {
    this.s = s;
  }

  public synchronized String getStringLength() {
    return s.length();
  }

}