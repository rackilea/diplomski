List<String> names = new ArrayList<String>();
List<String> ids = new ArrayList<String>();
Pattern p = Pattern.compile("\"(.*?)\",\"(.*?)\"") ;
Matcher m = p.matcher(s);
while(m.find()){
    names.add(m.group(1));
    ids.add(m.group(2));
}