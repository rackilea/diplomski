class StringAdder implements Adder<String> {
  @Override public String add(String a, String b) {
    return a + b;
  }
}

class IntegerAdder implements Adder<Integer> {
  @Override public Integer add(Integer a, Integer b) {
    return a + b;
  }
}