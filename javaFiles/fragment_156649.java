private <T> T getColumnByName(Row row, String name, Class<T> type) {
  if (type == Long.class) {
    return type.cast(row.getLong(name));
  } else if (type == String.class) {
    return type.cast(row.getString(name));
  } ... continued...
}