Pattern p = Pattern.compile("(?:(?:opening by [^ ]+)|(?:closing))"
            + "((?:[^\\.]*? )*(ONE|ANOTHER)(?:[^\\.]*?))\\."
            , Pattern.CASE_INSENSITIVE);
    final String text = "random text random text random text opening "
            + "by xysd FIRST ONE I WANT TO GET. random text random "
            + "text random text closing SECOND ANOTHER I WANT TO GET. "
            + "random text random text random text opening by lxcvznk "
            + "ANOTHER TEXT. random text random text random text random "
            + "text closing FOURTH ONE...etc";
    Matcher m = p.matcher(text);
    while(m.find())
    {
        System.out.println(m.group(1) + "<-" + m.group(2));
    }

FIRST ONE I WANT TO GET<-ONE
SECOND ANOTHER I WANT TO GET<-ANOTHER
ANOTHER TEXT<-ANOTHER
FOURTH ONE<-ONE