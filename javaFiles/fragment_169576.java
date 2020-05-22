private boolean filteredOne(String val, List<String> values) {
  boolean b = false;
  for(String s:values) {
    b |= s.equalsIgnoreCase(val);
  }
  return b;// true if one is equal
}

private boolean filteredAll(String val, List<String> values) {
  boolean b = true;
  for(String s:values) {
    b &= s.equalsIgnoreCase(val);
  }
  return b;// true if all are equal
}