ArrayList<Integer> newList = new ArrayList<Integer>();
for (Integer i: array) {
  if (i > 6) {
    newList.add(i);
  }
}
Integer[] newArray = newList.toArray(new Integer[0]);