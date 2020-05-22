public static void main(String[] args) {
    print(SomeEnum1.something1);
}

public static <T extends Enum & SomeInterface> void print(T t) {
    System.out.println(t.name() + " " + t.doSomething());
}