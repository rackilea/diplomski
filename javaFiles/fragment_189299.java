public class Test {
    public static void main(String[] args) {
        Test.biConsumerTest("A", "B", Test::testBiConsumer);
    }

    public static <T> void biConsumerTest(T a, T b, BiConsumer<T, T> biConsumer) {
        biConsumer.accept(a, b);
    }

    public static <S> void testBiConsumer(S a, S b) {
        System.out.println(a);
        System.out.println(b);
    }
}