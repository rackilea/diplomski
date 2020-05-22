double sum1(int i) {
  if(i==1) {
    return 1.0;
  } else {
    return sum1(i-1) + 1.0/i;
  }
}