final String regex = "v=([^\\s&#]*)";
    final String string = " https://m.youtube.com/watch?v=9tg3csrFVJw";
    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    final Matcher matcher = pattern.matcher(string);

    if(matcher.find()) {
        System.out.println(matcher.group(1));
    }