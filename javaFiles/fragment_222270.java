for (int i = 0; i < 1838265625; ++i) {
  int ii = i;
  int f = ii % 35; ii /= 35;
  int e = ii % 35; ii /= 35;
  int d = ii % 35; ii /= 35;
  // ...
  int a = ii % 35;

  list.add("" + array[a] + array[b] + array[c] + array[d] + array[e] + array[f]);
}