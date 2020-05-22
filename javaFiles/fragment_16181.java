public class IncrementDemo {
    public static void main(String[] args) {
        IntStream.generate(new IncrementGenerator()).parallel()
                 .limit(200).forEachOrdered(System.out::println);
    }
}
class IncrementGenerator implements IntSupplier {
    private int previous = 0;

    @Override
    public int getAsInt() {
        return previous++;
    }
}