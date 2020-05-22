public interface IComparable<T> extends Comparable<T> {

    default boolean isLessThan(T other) {
        return compareTo(other) < 0;
    }

    default boolean isLessOrEqualTo(T other) {
        return compareTo(other) <= 0;
    }

    default boolean isGreaterOrEqualTo(T other) {
        return compareTo(other) >= 0;
    }

    default boolean isGreaterThan(T other) {
        return compareTo(other) > 0;
    }

}