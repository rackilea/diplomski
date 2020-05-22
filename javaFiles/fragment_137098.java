import java.lang.reflect.Array;

class MyArray<T> {
    T[] a;

    MyArray(Class<T> type) {
        this.a = (T[]) Array.newInstance(type, 1);
    }

    T get(int index) {
        return a[index];
    }
}