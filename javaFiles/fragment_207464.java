String[] tests = {
    "A wild adventure",      // true
    "A wild wild adventure"  // false
};
for (String test : tests) {
    System.out.println(!test.matches(".*\\b(\\w+)\\s\\1\\b.*"));
}