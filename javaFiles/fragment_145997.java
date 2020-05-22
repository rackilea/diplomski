String idInfo = "Any text up here\n" +
        "Here is the id\n" +
        "\n" +
        "?a0 12 b5\n" +
        "&Edit Properties...\n" +
        "And any text down here";
Pattern regex = Pattern.compile("Here is the id\\n+\\?([a-z0-9]{2}(?:\\s[a-z0-9]{2})*)(?=\\n&Edit Properties)");
Matcher matcher = regex.matcher(idInfo);
while(matcher.find()){
        System.out.println(matcher.group(1));
}