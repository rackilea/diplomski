if (x%2 != y%2) {
  if (x%2==0) {
     return -1;
  } else {
     return 1;
  }
} else {
  return x.compareTo(y);
}