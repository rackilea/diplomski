public class MyClass<T extends Comparable<T>> implements
        Comparable<MyClass<T>> {
    T a;

    MyClass(T x) {
        a = x;
    }

    public String toString() {
        if (a == null) return "null";
        return a.toString();
    }

    @Override
    public int compareTo(MyClass<T> o) {
        if (this.a == null) {
            if (o == null || o.a == null) return 0;
            return -1;
        } else if (o == null || o.a == null) return 1;
        return this.a.compareTo(o.a);
    }
}