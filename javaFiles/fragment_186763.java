String value = getOptionalKey("uma"); // oblivious

try {
    String value = getKey("uma"); // cognisant
}
catch (KeyNotFoundException e) {
    // panic
}