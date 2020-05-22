Iterator<String> itemIterator = Arrays.asList(items).iterator();
if (itemIterator.hasNext()) {
  // special-case first item.  in this case, no comma
  while (itemIterator.hasNext()) {
    // process the rest
  }
}