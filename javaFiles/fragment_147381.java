int size = list.size();
for (int i = currentTemp; i < size - 1; i++) {
  if (!indexesToRemove.contains(i + 1)) {
    if (isEqual(list.get(currentTemp), list.get(i+1))) {
      indexesToRemove.add(i + 1);
    }
  }
}