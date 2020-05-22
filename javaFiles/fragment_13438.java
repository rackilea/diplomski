class Test {
  public static void main(String[] args) {
    String str = "word <a href=\"word\">word</word>word word";
    str = str.replaceAll("word(?!([^<]+)?>)", "repl");
    System.out.println(str);
  }
}