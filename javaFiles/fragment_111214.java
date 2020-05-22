public int getFreq(String word) {
  int val = word.charAt(0) - 64;
  if (val < 0 || val >= c.length || c[val] == null)
    return -1;
  ...
}