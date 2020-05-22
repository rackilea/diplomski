(in the store routines)

  if (array[index] == null) {
    loadCount++;
  }
  if (loadCount / arraySize > maxLoad) {
    resizeUp(...);
  }

  (in the remove routines)
  if (array[index] is cleared to null) {
    loadCount--;
  }
  if (loadCount / arraySize < minLoad) {
    resizeDown(...);
  }