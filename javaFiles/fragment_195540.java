public static <T> boolean lessThanOrEqualTo(T[] arr1, T[] arr2) {
  Set<T> firstSet=new HashSet<T>(Arrays.asList(arr1));
  Set<T> secondSet=new HashSet<T>(Arrays.asList(arr2));
  int countOfFirst=firstSet.size();
  firstSet.retainAll(secondSet);
  return firstSet.size() == countOfFirst;
}