Map<Object, Object> map = new TreeMap<>(yourPropertiesObject);
try(PrintWriter printer = new PrintWriter(yourOutputFile)) {
  for (Entry<Object, Object> e : map.entrySet()) {
    printer.println(String.format("%s=%s", e.getKey(), e.getValue()));
  }
}