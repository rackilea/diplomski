class Checker<T>{

  private T value;
  private Function<T, T> callback;

  private Checker(T value) {
    this.value = value;
  }

  public static Checker<String> when(String o) {
    return new Checker<>(o);
  }

  public static Checker<Integer> when(int o) {
    return new Checker<>(o);
  }

  public Checker<T> then(Function<T, T> callback) {
    this.callback = callback;
    return this;
  }

  public T execute() {
    return this.callback.apply(value);
  }

  public static void main (String[] args) {
    Checker.when("123").then(str -> {
      return "." + str + ".";
    }).execute();

    Checker.when(123).then(i -> {
      return i + 100;
    }).execute();
  }
}