public void shift(int n) {
  int[] temp = new int[datas.length];
  for (int i = 0; i < temp.length; i++) {
    temp[i] = datas[(i + n) % temp.length];
  }
  datas = temp;
}