public final class Color {

  private String id;
  public final int ord;
  private static int upperBound = 0;

  private Color(String anID) {
    this.id = anID;
    this.ord = upperBound++;
  }

  public String toString() {return this.id; }
  public static int size() { return upperBound; }

  public static final Color RED = new Color("Red");
  public static final Color GREEN = new Color("Green");
  public static final Color BLUE = new Color("Blue");
}