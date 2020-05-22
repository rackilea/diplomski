public class Foo {
    private int[] array;

    public Foo(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    /** @return a copy of the array */
    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }
}