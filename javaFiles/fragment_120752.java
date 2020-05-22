public void search(String key,List list) {
  System.out.println("\nSearching for " + key);

  int result = Collections.binarySearch(list, key);
  if (result >= 0)
     System.out.print(" Found at index " + result);
  else
     System.out.print(" Not found [" + result + "]");
}