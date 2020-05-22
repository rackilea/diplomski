try (
    InputStream fs = new FileInputStream("data.txt");
    InputStreamReader isr = new InputStreamReader(fs, StandardCharsets.UTF_8);
    BufferedReader br = new BufferedReader(isr)) {
    // Previous line
    String prev = null;
    // Last line
    String last = null;
    String line;
    while ((line = br.readLine()) != null) {
        prev = last;
        last = line;
    }
    // Pattern used to extract the integers
    Pattern pattern = Pattern.compile("\\d+");
    // Matcher for the previous line
    Matcher matcher1 = pattern.matcher(prev);
    // Matcher for the last line
    Matcher matcher2 = pattern.matcher(last);
    // Iterate as long as we have a match in both lines
    while (matcher1.find() && matcher2.find()) {
        // Value of previous line
        int val1 = Integer.valueOf(matcher1.group());
        // Value of last line
        int val2 = Integer.valueOf(matcher2.group());
        // Do something here
    }
}