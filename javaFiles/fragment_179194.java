boolean array[n]; // The array
int lastTrue = n;
for (int i = n-1; i >= 0; --i) {
  if (array[i]) {
    swap(array[--lastTrue], array[i]);
  }
}