private int findFreeLocation() {
  for (int i = 0; i < entryDirectory.length; i++) {
    if (entryDirectory[i] == null) {
        return i
    }
  }
  return -1;
}