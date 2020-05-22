class Foo {
  public static void main(String args[]) {
    final String str = "1-2-3";

    for (int idx = 0; idx < str.split("\\D").length; idx++) {
    }
  }
}