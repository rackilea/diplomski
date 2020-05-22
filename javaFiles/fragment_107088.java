ArrayList<String> list = new ArrayList<String>();
String s = "id=? AND name=?";
Matcher m = Pattern.compile("[^\\s=?]+(?=[=?])").matcher(s);
while(m.find()){
list.add(m.group());
}
System.out.println(list);