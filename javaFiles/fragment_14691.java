public class MyClass<T extends Comparable<T>> {
    T a;

    MyClass(T x) {
        a = x;
    }

    public String toString() {
        if (a == null) return "null";
        return a.toString();
    }
}

public class MyClassComparator<T extends Comparable<T>> implements
        Comparator<MyClass<T>> {
    @Override
    public int compare(MyClass<T> left, MyClass<T> right) {
        if (left == null) {
            if (right == null) {
                return 0;
            }
            return -1;
        } else if (right == null) {
            return 1;
        }
        if (left.a == null) {
            if (right.a == null) {
                return 0;
            }
            return -1;
        } else if (right.a == null) {
            return 1;
        }
        return left.a.compareTo(right.a);
    }
}