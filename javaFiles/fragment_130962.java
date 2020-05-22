String s1="<tag1 attr1=\"val1\"><tag2></tag2></tag1>";
Pattern p = Pattern.compile("^<(.*?)>");
Matcher m = p.matcher(s1);
while(m.find()) {
    System.out.println(m.group(1));
}