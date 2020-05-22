public static void main(String[] args) {

    java.util.function.Function<String, String> f2 = (String b) -> b.toUpperCase();

    test((String a) -> a.toUpperCase());
    test(f2);

}

public static void test(com.google.common.base.Function<String, String> f) {

}