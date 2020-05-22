String val="dev\\ devendra. devendra, dev dev, dev; devendra: wan.gikar devendra: windchill- windchill- serviceCenter_ sC_Windchill";
    String REGEX="\\w+[\\\\.:;_,-]+(?= |$)";
    Pattern pattern = Pattern.compile(REGEX);
    Matcher matcher = pattern.matcher(val);
    while(matcher.find()){
        System.out.println(matcher.group());
    }