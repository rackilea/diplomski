String s = "|India| vs |Aus|";
    Pattern p = Pattern.compile("\\|(.*?)\\|");
    Matcher m = p.matcher(s);
    while(m.find()){
        System.out.println(m.group(1));
    }