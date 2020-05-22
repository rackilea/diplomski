public void trimValues(Map<?, String> map) {
  for (Map.Entry<?, String> e : map.entrySet()) {
    String val = e.getValue();
    if (val != null)
      e.setValue(val.trim());
  }
}