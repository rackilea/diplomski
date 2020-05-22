// Double-check idiom for lazy initialization of instance fields.
private volatile FieldType field;
FieldType getField() {
  FieldType result = field;
  if (result == null) { // First check (no locking)
    synchronized(this) {
      result = field;
      if (result == null) // Second check (with locking)
        field = result = computeFieldValue();
    }
  }
  return result;
}