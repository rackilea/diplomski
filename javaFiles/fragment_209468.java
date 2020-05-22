public int strDist(String str, String sub) {
  int first = str.indexOf(sub);
  if (first == -1)
    return 0;
  int last = str.lastIndexOf(sub);
  return last - first + sub.length();
}