for (int i = currentTemp; i < list.size() - 1; i++) {
  synchronized (list) {
    if (i + 1 > list.size() && isEqual(list.get(currentTemp), list.get(i+1))) {
      list.remove(i + 1);
      i--;
    }
  }
}