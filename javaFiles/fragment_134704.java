public class T {
    public T(Class<? extends Map<MyClassType1, Object>> cls) {
    }

    public static void main(String[] args) {
        Map<MyClassType1, Object> m = new HashMap<MyClassType1, Object>();
        T t = new T(m.getClass());
    }
}