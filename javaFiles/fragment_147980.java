public WV wrapValue(V value) {
    try {
        return (WV) value;
    } catch (Exception e) {
        return null;
    }
}