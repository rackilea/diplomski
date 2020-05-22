final Iterator<String> iterator = sejarahToken.iterator();

while (iterator.hasNext()) {
  final String e = iterator.next();

  if (e == null || e.trim().isEmpty())
    iterator.remove();
}