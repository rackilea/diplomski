public class GrowableArray<T> {
  // Default empty to size 10.
  private static final int DefaultLength = 10;
  // My current array.
  private T[] array;

  // Empty constructor.
  GrowableArray () {
    // Passing no 2nd param at all forces jvm to manufacture an empty one for me - which is an array<T>.
    array = makeNew(DefaultLength);
  }

  // Make a new one of the right size.
  private T[] makeNew(int length, T... sample) {
    return Arrays.copyOf(sample, length);
  }
}