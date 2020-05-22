public void addEntry(Entry newEntry) {
  int loc = findFreeLocation();
  if (loc >= 0) {
    entryDirectory[loc] = newEntry;
  } else {
    entryDirectory = Arrays.copyOf(entryDirectory, entryDirectory.length + 1);
    entryDirectory[entryDirectory.length - 1] = newEntry;
  }
}