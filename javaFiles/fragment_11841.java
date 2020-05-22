public class DefaultArray {
    private final int defaultValue;
    private final int[] array;

    public DefaultArray(int length, int defaultValue) {
        this.array = new int[length];
        this.defaultValue = defaultValue;
    }

    public int get(int i) {
        // ask permission!
        if(i >= 0 && i < array.length) {
            return array[i];
        } else {
            return defaultValue;
        }
    }
    public void set(int i, int value) {
        array[i] = value;
    }
    public int length() {
        return array.length;
    }
}