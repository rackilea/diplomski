static int indexOfById(List<?> list, Object searchedObject) {
  int i = 0;
  for (Object o : list) {
    if (o == searchedObject) return i;
    i++;
  }
  return -1;
}