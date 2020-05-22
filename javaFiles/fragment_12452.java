void append(StringBuilder stringBuilder, String name, Object value) {
  stringBuilder.append(name);
  if (value == null) {
    stringBuilder.append(" is null");
  } else {
    stringBuilder.append(" == '").append(value).append("'").append(" and ");
  }
}