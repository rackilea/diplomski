int countOccurrences(String str, String search) {
  return recurse(str, search, 0, 0);
}

int recurse(String str, String search, int count, int i) {
  i = str.indexOf(search, i);
  if (i == -1) {
    // Like the while loop where i == -1, i.e. no more occurrences found.
    // Break the recursion.
    return count;
  } else {
    // Like the while loop where i != -1: an occurrence was found.
    // Increment count, and keep on searching.
    return recurse(str, search, count + 1, i + search.length());
  }
}