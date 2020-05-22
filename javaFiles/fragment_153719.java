public class MyMain {

  public static volatile MsLunch publicLunch;

  public static void main(String... args) {
    MsLunch lunch = new MsLunch();
    publicLunch = lunch;
    //...
  }
}