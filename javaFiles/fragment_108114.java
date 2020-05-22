Iterable<String> words = ...;
Bag<String> counts = new HashBag<String>();
for (String word : words) {
  counts.add(word);
}
for (String word : counts.uniqueSet()) {
  int count = counts.getCount(word);
  System.out.println(word + "\t" + count);
}