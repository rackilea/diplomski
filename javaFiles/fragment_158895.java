for(int i=0; i<10; i++) {
  int a = arr1[9-i] + arr2[9-i];
  if (a>9) {
    result[9-i] = a-10;
    result[10-i] += 1;
  } else {
    result[9-i] = a;
  }
}