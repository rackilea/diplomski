String[] strings = new String[]{"hello", "blah", "--673b0e57-A--", "something", "--673b0e57-B--"};
    Pattern p = Pattern.compile("--.*-(\\w)--");
    for(String s : strings)
    {
        Matcher m = p.matcher(s);
        if(m.find())
        {
            System.out.println("Current part is "+m.group(1));
        }
    }