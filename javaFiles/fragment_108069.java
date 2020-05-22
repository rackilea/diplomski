List<String> functions = Arrays.asList("f()", "f(); g()", "f(1,2)", "f(1,2);    g(1)");
String regex = "([a-z]+\\(.*?\\));?";
String regex2 = "([a-z]+)\\((.*?)\\)";
for (String func : functions) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(func);
    while (matcher.find()) {
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(matcher.group(1));
        if (matcher2.find()) {
            System.out.println("function name = " + matcher2.group(1) + ", params "
                    + Arrays.asList(matcher2.group(2).split(",")));
        }
    }
}