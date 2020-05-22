final int[] arr = // elements you want
List<Integer> indices = new ArrayList<Integer>(arr.length);
for (int i = 0; i < arr.length; i++) {
  indices.add(i);
}
Comparator<Integer> comparator = new Comparator<Integer>() {
  public int compare(Integer i, Integer j) {
    return Integer.compare(arr[i], arr[j]);
  }
}
Collections.sort(indices, comparator);