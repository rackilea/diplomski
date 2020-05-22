@Override public void write(JsonWriter out, T value) throws IOException {
  if (value == null) {
    out.nullValue();
    return;
  }

  out.beginObject();
  try {
    for (BoundField boundField : boundFields.values()) {
      if (boundField.writeField(value)) {
        out.name(boundField.name);
        boundField.write(out, value);
      }
    }
  } catch (IllegalAccessException e) {
    throw new AssertionError(e);
  }
  out.endObject();
}