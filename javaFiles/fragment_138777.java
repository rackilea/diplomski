public static void main(String[] args) {
    Matcher matcher = Pattern.compile("(.)", Pattern.DOTALL).matcher("foobar");
    if (matcher.find()) {
        System.out.println(matcher.group(1)); // prints "f"
    }
}