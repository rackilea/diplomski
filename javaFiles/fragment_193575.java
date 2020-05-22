String data = "name=;display={ xyz=deno; demo2=pol };addressname={123}";

Pattern p = Pattern.compile("(?<name>\\w+)=(\\{(?<value>[^}]*)\\})?(;|$)");
Matcher m = p.matcher(data);

while (m.find()){
    System.out.println(m.group("name")+"->"+(m.group("value")==null?"":m.group("value").trim()));
}