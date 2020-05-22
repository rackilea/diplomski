interface Base<K> {
    K get();
}

interface A extends Base<String> {
    String get();
}

interface B extends Base<Integer> {
    Integer get();
}

interface AB extends A, B {
    ??
}