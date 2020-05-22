class Test<X> {
    void test() {
        Supplier<TypeToken<X>> s1 = () -> new TypeToken<X>() {};
        Supplier<TypeToken<String>> s2 = () -> new TypeToken<String>() {};
        Supplier<TypeToken<List<String>>> s3 = () -> new TypeToken<List<String>>() {};
    }
}