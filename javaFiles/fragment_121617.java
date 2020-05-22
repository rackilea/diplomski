public static void main(String[] args) throws Exception {
    String string = "#hashtags and @mentions";
    Matcher matcher = Pattern.compile("^[@#]\\w+|(?<=\\s)[@#]\\w+").matcher(string);
    while (matcher.find()) {
        System.out.println(matcher.group());
    }
}