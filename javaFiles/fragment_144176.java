class A {
    final String text = dynamic("Hello");
    // or final String text = String.valueOf("Hello");

    public static void main(String... args) {
        System.out.println(new A().text);
    }

    static <T> T dynamic(T t) {
        return t;
    }
}