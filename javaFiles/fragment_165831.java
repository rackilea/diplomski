public boolean More ...getBoolean(String key, boolean defaultValue) {
    Object o = mMap.get(key);
    if (o == null) {
        return defaultValue;
    }
    try {
        return (Boolean) o;
    } catch (ClassCastException e) {
        typeWarning(key, o, "Boolean", defaultValue, e);
        return defaultValue;
    }
}