/**
 * removes duplicates in the provided sorted array
 * @return the number of different elements (they're at the beginning)
 */
public static int shrink(int[] array) {
    int w = 0;
    for (int i=0; i<array.length; i++) {
      if (i==0 || array[i]!=array[i-1]) {
          array[w++]=array[i];
      }
    }
    return w;
}