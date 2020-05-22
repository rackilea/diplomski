int i = 0;
while (i < arr.length) {
  int start = i;
  while (i < arr.length && arr[i].equals(arr[start])) {
    ++i;
  }
  int count = i - start;
  System.out.println(arr[start] + " " + count);
}