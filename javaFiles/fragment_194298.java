Pattern pattern = Pattern.compile("(\\w+)([<=>]+)(\\w+)");
    Matcher matcher = pattern.matcher("var1>=ar2b");

    if(matcher.find()){
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
    }