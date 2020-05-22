@SuppressWarnings("unchecked")
public static <T> T[] createArrayInstance(T obj) {
    T[] a = (T[])Array.newInstance(obj.getClass(), 1);//or whatever size you want
    a[0] = obj;
    return a;
}