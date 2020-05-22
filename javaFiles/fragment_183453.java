private static final Map<String, Runnable> stringToRunnable = new HashMap<>();

{
  stringToRunnable.put("a", this::doSomething);
  stringToRunnable.put("b", this::doSomethingElse);
  stringToRunnable.put("c", this::doSomethingElseElse);
}

public static void main(String[] args) {
  List<String> names = Arrays.asList("1", "2", "b", "a");
  names.stream()
      .filter(stringToRunnable::containsKey)
      .findFirst()
      .ifPresent(name -> stringToRunnable.get(name).run());
}

private void doSomethingElseElse() {
}

private void doSomethingElse() {
}

public void doSomething() {
}