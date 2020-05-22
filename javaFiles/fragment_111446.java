int myHash(int[] seedAry) {
  int result = 17;
  for (int s : seedAry) {
    result = 31 * result + s;
  }
  return result;
}