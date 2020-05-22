public static int maxIndex(List<Integer> list) {
  Integer i=0, maxIndex=-1, max=null;
  for (Integer x : list) {
    if ((x!=null) && ((max==null) || (x>max))) {
      max = x;
      maxIndex = i;
    }
    i++;
  }
  return maxIndex
}
// ...
maxIndex(Arrays.asList(1, 2, 3, 2, 1)); // => 2
maxIndex(Arrays.asList(null, null)); // => -1
maxIndex(new ArrayList<Integer>()); // => -1