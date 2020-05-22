public class ImmutableIntArray {

    private final int[] array;

    public ImmutableIntArray() {
        int[] tmp = new int[10];
        for (int i = 0; i < 10; i++) {
            tmp[i] = i;
        }
        array = tmp;
    }

    // get() etc.
}