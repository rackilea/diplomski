// You can parse your xml output using regXp:
    String s = "<root><date>2012-01-01T08:44:36+01:00</date></root>";

    Pattern pattern = Pattern.compile("(.+)(T)(.+)([+-])");
    Matcher matcher = pattern.matcher(s);

    if (matcher.find()) {
        System.out.println(matcher.group(1) + ' ' + matcher.group(3));
    } else {
        System.err.println("Bad date: " + s);
    }