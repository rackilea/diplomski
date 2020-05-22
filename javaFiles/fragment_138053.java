Iterator<String> iterator = notes.iterator();
while(iterator.hasNext()) {
  String file = iterator.next();
  if (file == r)
    iterator.remove();
}