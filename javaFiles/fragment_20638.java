public class Scratch {

  public static int newPos(int i, int len) {
    return i < len/2 ? i * 2 : (i - len/2) * 2 + 1;
  }

  public static int swapChain(int index0, String[] arr) {
    int i = index0;
    int nextStart = i + 1;
    int newPos = newPos(i, arr.length);
    String s = arr[newPos];
    arr[newPos] = arr[i];
    i = newPos;
    do {
      if (i == nextStart) {
        nextStart++;
      }
      newPos = newPos(i, arr.length);
      String t = arr[newPos];
      arr[newPos] = s;
      s = t;
      i = newPos;
    } while (i != index0);

    boolean valid;
    do {
      valid = true;
      i = nextStart;
      do {
        i = newPos(i, arr.length);
        if (i < nextStart) {
          nextStart++;
          if (nextStart >= arr.length / 2) {
            return nextStart;
          }
          valid = false;
          break;
        }
      } while (i != nextStart);
    } while (!valid);
    return nextStart;
  }

  public static void shuffle(String[] arr) {
    int start = 1;
    do {
      start = swapChain(start, arr);
    } while (start < arr.length / 2);
    System.out.println(Arrays.toString(arr));
  }

  public static void main(String[] args) {
    shuffle(new String[]{"1", "2", "3", "a", "b", "c"});
  }
}