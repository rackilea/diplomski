Map<String, byte[]> m = (Map)parObj;
for (Map.Entry<String, byte[]> entry : m.entrySet()) {
  String key = entry.getKey();
  byte[] value = entry.getValue();
  // do whatever you need with the key and value...
}