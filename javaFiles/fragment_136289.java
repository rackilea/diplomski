public void test1() {
    String text = "Breakpoint 10, main () at file.c:10";
    String regex = ",(.*) at";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
        System.out.println(matcher.group(1));
    }
}