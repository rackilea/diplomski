public boolean containsSubstring(String input, String check) {
    if (!input.contains(check)) {
        throw new AssertionError("'" + input + "' does not contain '" + check + "'");
    }
    return true;
}