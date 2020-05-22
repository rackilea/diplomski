public static <K, V> boolean linkedEquals( LinkedHashMap<K, V> left, LinkedHashMap<K, V> right) {
  Iterator<Entry<K, V>> leftItr = left.entrySet().iterator();
  Iterator<Entry<K, V>> rightItr = right.entrySet().iterator();

  while ( leftItr.hasNext() && rightItr.hasNext()) {
     Entry<K, V> leftEntry = leftItr.next();
     Entry<K, V> rightEntry = rightItr.next();

     //AbstractList does null checks here but for maps we can assume you never get null entries
     if (! leftEntry.equals(rightEntry))
         return false;
  }
  return !(leftItr.hasNext() || rightItr.hasNext());
}