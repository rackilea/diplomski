String regEx = "\\d[a-zA-Z]";
    String s= "Flat 3a Butterfly Street";
    Pattern pattern = Pattern.compile(regEx);
    Matcher matcher = pattern.matcher(s);

    while (matcher.find()) {
        System.out.println(matcher.group());
    }