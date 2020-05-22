// Double-check idiom for lazy initialization of instance fields
private volatile FieldType field;

private FieldType getField() {
    FieldType result = field;
    if (result != null) // First check (no locking)
        return result;
    synchronized(this) {
        if (field == null) // Second check (with locking)
            field = computeFieldValue();
        return field;
    }
}