public class JDK_8029516 {
    private static final Field bufferField = getField("sun.nio.fs.WindowsWatchService$WindowsWatchKey", "buffer");
    private static final Field cleanerField = getField("sun.nio.fs.NativeBuffer", "cleaner");
    private static final Cleaner dummyCleaner = Cleaner.create(Thread.class, new Thread());

    private static Field getField(String className, String fieldName) {
        try {
            Field f = Class.forName(className).getDeclaredField(fieldName);
            f.setAccessible(true);
            return f;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static void patch(WatchKey key) {
        try {
            cleanerField.set(bufferField.get(key), dummyCleaner);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}