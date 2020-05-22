//pick a better name; this is just for demo purposes
public class Singleton {
    private static int[] array = {};
    private static boolean initialized = false;

    public static void initialize(int[] arr) {
        if(!initialized) {
            array = new int[arr.length];
            System.arraycopy(arr, 0, array, 0, arr.length);
            initialized = true;
        } else {
            throw new IllegalStateException("Array has already been initialized");
        }
    }

    public static int[] getArray() {
        return Arrays.copyOf(array, array.length);  
    }
}