int dest = 0;
for (int source = 0; source < arr.Length; source++) {
  if (arr[source] == 0) {
    arr[source] = arr[dest];
    arr[dest++] = 0;
  }
}