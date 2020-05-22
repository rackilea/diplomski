import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

interface Some<T> {
    static <T> Some<T> of(Supplier<T> supplier) {
        return new SomeImpl<>(supplier.get());
    }

    default Some<T> shout() {
        System.out.println(this);
        return this;
    }

    class SomeImpl<T> implements Some<T> {
        private final T value;

        public SomeImpl(T value) {
            this.value = value;
        }
    }

    static void main(String[] args) {
        final Some<List<CharSequence>> strings = Some.of(() -> Arrays.asList("a", "b", "c"));
    }
}