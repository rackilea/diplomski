String s1 = ""; //your string
    Pattern pattern = Pattern.compile("\\{(.*?)}");
    Matcher matcher = pattern.matcher(s1);
    while (matcher.find()) {
        String.format("{%s}", matcher.group(1));
    }