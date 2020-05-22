import java.util.Comparator;
import java.util.function.Function;

public class Test<T,U> {
  private final Function<U,T> function;
  private final Comparator<T> comparator;

  public Test(Function<U,T> function, Comparator<T> comparator) {
    this.function = function;
    this.comparator = comparator;
  }

  public static <E extends Comparable<E>, V> Test<E,V> withNatOrder(Function<V,E> function) {
      // Any of these two will do
      final Comparator<E> comp = (E a, E b) -> a.compareTo(b);
      final Comparator<E> comp2 = Comparator.naturalOrder();
      return new Test<>(function, comp);
  }
}