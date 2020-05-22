public class MultithreadedMergeSort extends RecursiveAction {

  private final int[] array;
  private final int begin;
  private final int end;

  public MultithreadedMergeSort(int[] array, int begin, int end) {
    this.array = array;
    this.begin = begin;
    this.end = end;
  }

  @Override
  protected void compute() {
    if (end - begin < 2) {
      // swap if we only have two elements
      if (array[begin] > array[end]) {
        int tmp = array[end];
        array[end] = array[begin];
        array[begin] = tmp;
      }
    } else {
      // overflow safe method to calculate the mid
      int mid = (begin + end) >>> 1;
      // invoke recursive sorting action
      invokeAll(new MultithreadedMergeSort(array, begin, mid),
          new MultithreadedMergeSort(array, mid + 1, end));
      // merge both sides
      merge(array, begin, mid, end);
    }
  }

  void merge(int[] numbers, int startA, int startB, int endB) {
    int[] toReturn = new int[endB - startA + 1];
    int i = 0, k = startA, j = startB + 1;
    while (i < toReturn.length) {
      if (numbers[k] < numbers[j]) {
        toReturn[i] = numbers[k];
        k++;
      } else {
        toReturn[i] = numbers[j];
        j++;
      }
      i++;
      // if we hit the limit of an array, copy the rest
      if (j > endB) {
        System.arraycopy(numbers, k, toReturn, i, startB - k + 1);
        break;
      }
      if (k > startB) {
        System.arraycopy(numbers, j, toReturn, i, endB - j + 1);
        break;
      }
    }
    System.arraycopy(toReturn, 0, numbers, startA, toReturn.length);
  }

  public static void main(String[] args) {
    int[] toSort = { 55, 1, 12, 2, 25, 55, 56, 77 };
    ForkJoinPool pool = new ForkJoinPool();
    pool.invoke(new MultithreadedMergeSort(toSort, 0, toSort.length - 1));
    System.out.println(Arrays.toString(toSort));

  }