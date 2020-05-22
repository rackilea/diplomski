List<String> tokens = new ArrayList<String>();
    tokens.add("hello");

    String patternString = "\\b(" + StringUtils.join(tokens, "|") + ")\\b";
    Pattern pattern = Pattern.compile(patternString);
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
        System.out.println(matcher.group(1));
    }