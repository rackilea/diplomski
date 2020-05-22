Iterator<? extends Entry<? extends String, ? extends String>> iterator =
    m.entrySet().iterator();

while (iterator.hasNext()) {
    Entry<? extends String, ? extends String> entry = iterator.next();
    String key = entry.getKey();
    String value = entry.getValue();
}