public static void main(String[] args) {
    test(null);
}

public static void test(Optional<Object> optional) {
    System.out.println(optional.orElse(new DefaultObject()));
}