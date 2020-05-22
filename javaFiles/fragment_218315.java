/** Interface responsible for sorting an array of doubles. */
@FunctionalInterface // we'll come back to this
public interface Sorter {
  /** Sorts the input array in ascending order. */
  void sort(double[] arr);
}