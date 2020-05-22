int countOccurrences(String str, String search) {
  int count = 0;
  int i = 0;
  while (true) {
    i = str.indexOf(search, i);
    if (i == -1) {
      break;
    } else {
      count += 1;
      i += search.length();
    }
  }
  return count;
}