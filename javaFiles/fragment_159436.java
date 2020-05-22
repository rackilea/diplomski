Pattern pattern = Pattern.compile("^172\\.(1[6789]|2\\d|30|31)\\.");
String[] test_strings = {"172.19.0.0", "172.24.0.0", "172.45.0.0", "172.19.98.94"};
for (String string : test_strings) {
    Matcher matcher = pattern.matcher(string);
    if (matcher.find())
        System.out.println(matcher.group(1));
    else
        System.out.println();
}