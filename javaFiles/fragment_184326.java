Pattern pattern = Pattern.compile("^\\[(.*?)] \\[(.*?)] \\[(.*?)] (/.*?)(\\?.*)?$");
String[] ss = { "[txt1] [txt2] [txt3] /some/long/path?params=1,2,3", "[txt1] [txt2] [txt3] /path/", "[txt1] [txt2] [txt3] /"};
for (String s: ss) {
    Matcher matcher = pattern.matcher(s);
    while (matcher.find()){
        System.out.println("Next match for \"" + s + "\"" ); 
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2)); 
        System.out.println(matcher.group(3)); 
        System.out.println(matcher.group(4)); 
        System.out.println(matcher.group(5)); 
    } 
}