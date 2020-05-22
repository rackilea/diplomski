import java.util.*;

class Foo<T extends Comparable<? super T>> {

    private Comparator<T> comparator;

    public void someMethod(Comparator<T> comparator)
    {
       this.comparator = comparator;                  // no compile error
       this.comparator = Comparator.<T>naturalOrder(); // <T> is optional, compiler can infer
    }
}