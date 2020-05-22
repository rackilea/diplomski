final String input = "pw:(abc) something!";

    Matcher matcher = Pattern.compile("\\(.*\\)").matcher(input);

    if (matcher.find()) {
        final String onlyPw = matcher.group();
        final String stars = StringUtils.repeat("*", onlyPw.length());

        System.out.println(input.replace(onlyPw, stars));
    }