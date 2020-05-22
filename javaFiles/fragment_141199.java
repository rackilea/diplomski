public String deleteAllExcept(String input, String needle) {
    StringBuilder sb = new StringBuilder();

    // Find all occurrences
    Pattern needlePatt = Pattern.compile(needle);
    Matcher matcher = needlePatt.matcher(input);
    while (m.find()) {
        // Build the result
        sb.append(needle);
    }

    return sb.toString();
}