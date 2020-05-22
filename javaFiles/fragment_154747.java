public void test() {
  Pattern regex = Patterns.regex("-?\\d+");
  Parser<Integer> integer = Scanners.pattern(regex, "Integer").source().map(new    Map<String, Integer>() {
      @Override
      public Integer map(String s) {
        return Integer.parseInt(s);
      }
    });

  assertEquals(-42, (int) integer.parse("-42"));
 }