String s_Result="Distance: 2.8km (about 9 mins)";
Pattern p = Pattern.compile("(\\d+(\\.\\d+)?) ?(\\w+?)\\b");
Matcher m = p.matcher(s_Result);
while(m.find()){
    MatchResult mr=m.toMatchResult();
    String value=mr.group(1);//2.8 and 9 come here
    String units=mr.group(3);//km and mins come here
}