String[] samples = { 
    "1",
    "12",
    "1234",
    "123",
    "123a",
    "1a234",
    "a1234b",
    "a1bcd2e",
    "a1bcd2e3",
    "a1bde2e34"
};
for (String s: samples) {
    System.out.println(s + "\t" +
            java.util.regex.Pattern.matches("(([a-z]*\\d){1}|([a-z]*\\d){2}|([a-z]*\\d){4})[a-z]*", s));
}