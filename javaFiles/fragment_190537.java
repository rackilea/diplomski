String s_Result="Distance: 2.8km (about 9 mins)";

//Distance parsing
Pattern p = Pattern.compile("Distance: (\\d+(\\.\\d+)?)(.*?)\\b");
Matcher m = p.matcher(s_Result);
if(m.find()){
    MatchResult mr=m.toMatchResult();
    f_Distance=mr.group(1);//2.8
    m_DistanceUnit=mr.group(3);//km
}

//Time parsing
p = Pattern.compile("about (\\d+(\\.\\d+)?) (.*)\\b");
m = p.matcher(s_Result);
if(m.find()){
    MatchResult mr=m.toMatchResult();
    f_timeEst=mr.group(1);//9
    m_timeEstUnit=mr.group(3);//min
}