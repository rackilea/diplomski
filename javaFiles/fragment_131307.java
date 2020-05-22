Iterator<String> it = words.iterator();
while (it.hasNext()) {
  if (it.next().equalsIgnoreCase(inputWord)) {
    it.remove();
  }
}