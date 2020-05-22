public static void main(String[] args) throws Exception {
    String data = "234 587.094 123 3.4 6 99999.9999 876";

    // Remove decimal numbers
    data = data.replaceAll("\\d+\\.\\d+", "");

    Matcher matcher = Pattern.compile("\\d+").matcher(data);
    while (matcher.find()) {
        System.out.println(matcher.group());
    }
}