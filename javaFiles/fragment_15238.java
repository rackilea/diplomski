public class Comparer<T>
{
    private final Supplier<T> supplier;

    Comparer(final Supplier<T> supplier)
    {
        this.supplier = supplier;
    }

    void compare(T value)
    {
        System.out.println(supplier.get() == value);
    }
}

new Comparer<>(this::getString).compare("Foo"); // Valid, as expected
new Comparer<>(this::getInt).compare("Foo"); // Invalid, compiler error
new Comparer<>(this::getString).compare(1);  // Invalid, compiler error