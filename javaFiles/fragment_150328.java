// read everything into a local cache
Collection<String> cache = new ArrayList<>();
while (iterator.hasNext()) cache.add(iterator.next());

// now you can get as many iterators from cache as required:
Iterator<String> iter = cache.iterator();
// use iter

iter = cache.iterator(); // once more
// use iter
...