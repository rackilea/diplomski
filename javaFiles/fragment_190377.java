Pattern p = Pattern.compile("(?:(?:opening by [^ ]+)|(?:closing))"
            + "((?:[^\\.]*? )*TEXT(?:[^\\.]*?))\\."
            , Pattern.CASE_INSENSITIVE);
    final String text = "random text random text random text opening "
            + "by xysd FIRST TEXT I WANT TO GET. random text random "
            + "text random text closing SECOND TEXT I WANT TO GET. "
            + "random text random text random text opening by lxcvznk "
            + "THIRD TEXT. random text random text random text random "
            + "text closing FOURTH TEXT...etc";
    Matcher m = p.matcher(text);
    while(m.find())
    {
        System.out.println(m.group(1));
    }