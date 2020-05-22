private Map<String, BoundField> getBoundFields(Gson context, TypeToken<?> type, Class<?> raw) {
  Map<String, BoundField> result = new LinkedHashMap<String, BoundField>();

  if (raw.isInterface()) {
    return result;
  }