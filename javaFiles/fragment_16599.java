Pattern p = Pattern.compile("window.map0Div\\s*=\\s*\\{.*lat:\\s*([0-9.]+),.*lng:\\s*([0-9.]+),");
Matcher m = p.matcher(content);
if (m.find()){
    String lat = m.group(1);
    String lng = m.group(2);
    //do whatever you need to do with the info
}