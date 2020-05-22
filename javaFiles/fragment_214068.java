String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
            + "My second question? Sed amet elementum."
            + "Integer nec diam erat, eu consectetur nibh?"
            + "Cum sociis natoque penatibus et magnis dis parturient montes.";
    Pattern pattern = Pattern.compile("([^.?!]*)\\?");
    Matcher matcher = pattern.matcher(str);
    while(matcher.find())
    {
        System.out.println(matcher.group());
    }