public class Main {
    private static Class<?> getDeclaredInterface(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        Class<?> objectClass = object.getClass();
        Class<?>[] implementedInterfaces = objectClass.getInterfaces();
        if (implementedInterfaces.length == 0) {
            throw new IllegalArgumentException(objectClass.getSimpleName() + " implements no interfaces.");
        }
        if (implementedInterfaces.length > 1) {
            throw new IllegalArgumentException(objectClass.getSimpleName() + " implements multiple interfaces.");
        }
        return implementedInterfaces[0];
    }

    public static void main(String... args) {
        Object object = (Closeable) () -> System.out.println("No-op.");
        System.out.println(getDeclaredInterface(object)); // prints 'interface java.io.Closeable'
    }
}