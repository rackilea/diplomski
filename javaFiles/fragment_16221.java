public interface IComparable<T> extends Comparable<T> {

    boolean isLessThan(T other);

    boolean isLessOrEqualTo(T other);

    boolean isGreaterOrEqualTo(T other);

    boolean isGreaterThan(T other);

}