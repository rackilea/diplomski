//create Pattern p, Matcher m and replacement map
StringBuffer sb = new StringBuffer();
while(m.find()){
    m.appendReplacement(sb, replacementsMap.get(m.group()));
}
m.appendTail(sb);
String replaced = sb.toString();