public static void main(String[] args) throws Exception {
    String source = " abc 2 de fdfg 3 4 fdfdfv juk  @  dfdfgd 45";

    // "\\d+" will get all of the digits in the String
    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(source);

    int sum = 0;
    // Convert each find to an Integer and accumulate the total
    while (matcher.find()) {
        sum += Integer.parseInt(matcher.group());
    }
    System.out.println("Sum: " + sum);
}