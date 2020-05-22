public static int indexOf(String str, String sub, int start, int direction) {
  if (start < 0 || start > str.length() - sub.length())
    return -1;
  if (str.substring(start, start + sub.length()).equals(sub))
    return start;
  return indexOf(str, sub, start+direction, direction);
}

public static int strDistRecursive(String str, String sub) {
  int first = indexOf(str, sub, 0, 1);
  if (first == -1)
    return 0;
  int last = indexOf(str, sub, str.length() - sub.length(), -1);
  return last - first + sub.length();
}