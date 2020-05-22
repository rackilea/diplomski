import java.util.Optional;
import java.util.function.Supplier;

public class Switch {

    @SafeVarargs
    public static <T, U> Optional<U> of(T value, Case<T, U>... cases) {
        for (Case<T, U> c : cases) {
            if (value.equals(c.getTestValue())) {
                return Optional.of(c.getSupplier().get());
            }
        }
        return Optional.empty();
    }

    public static <T, U> Case<T, U> when(T testValue, Supplier<U> supplier) {
        return new Case<T, U>() {
            public T getTestValue() {
                return testValue;
            }

            public Supplier<U> getSupplier() {
                return supplier;
            }
        };
    }

    public interface Case<T, U> {
        Supplier<U> getSupplier();

        T getTestValue();
    }
}