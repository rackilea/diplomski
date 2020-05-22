String str = "Hello: This is a Test:";
    Pattern p1 = Pattern.compile("(.*?):");
    Pattern p2 = Pattern.compile("(.*):");

    Matcher m1 = p1.matcher(str);
    if (m1.find())
    {
        System.out.println(m1.group(1));            
    }

    Matcher m2 = p2.matcher(str);
    if (m2.find())
    {
        System.out.println(m2.group(1));
    }