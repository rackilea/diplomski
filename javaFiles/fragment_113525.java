public static void main(String[] args) throws Exception {
    String data = "234 587.094 123 3.4 6";
    Matcher matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(data);
    while (matcher.find()) {
        if (matcher.group(1) == null) {
            System.out.println(matcher.group());
        }
    }
}