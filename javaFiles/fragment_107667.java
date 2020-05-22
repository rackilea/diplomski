// BAD
String process(String s) {
    return Optional.ofNullable(s).orElseGet(this::getDefault);
}

// GOOD
String process(String s) {
    return (s != null) ? s : getDefault();
}