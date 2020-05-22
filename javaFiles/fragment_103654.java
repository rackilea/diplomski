Iterator<String> itr = entry.getValue().iterator();
while (itr.hasNext()) {
  if (itr.next().startsWith("a")) {
    itr.remove();
  }
}