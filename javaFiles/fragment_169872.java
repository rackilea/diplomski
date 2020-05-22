public <T> T getValue(Class<T> cls) {
    if (valVal == null) return null;
    else {
        if (cls.isInstance(valVal)) return cls.cast(valVal);
        return null;
    }
}