Iterator<String> it = calList.iterator();
while (it.hasNext()) {
  if (it.next().contains("54<:>")) {
    it.remove();
    // Add break; here if you want to remove just the first match.
  }
}