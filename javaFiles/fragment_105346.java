private boolean checkIfIncreasing(List<T> elements, int index) {
  if (elements.size() < 2 || index + 1 == elements.size())
      return true;
  if (elements.get(index).compareTo(elements.get(index+1)) < 1)
      return checkIfIncreasing(elements, index+1);
  return false;
}