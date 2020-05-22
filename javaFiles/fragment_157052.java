String[] data={"+123456","00123456","123456"};
Pattern p=Pattern.compile("(?:00|\\+)?(\\d+)");
Matcher m=null;
for (String s:data){
    m=p.matcher(s);
    if(m.find())
        System.out.println(m.group(1));
}