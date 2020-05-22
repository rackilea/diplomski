String input = PUT YOUR STRING HERE!;
String pattern = "(?<=:\")((?=",|\"$)|.)+";
ArrayList<String> out = new ArrayList<String>();
Pattern p = Pattern.compile(pattern, Pattern.MULTILINE);
Matcher m = p.matcher(input);

while(m.find()){
  out.add(m.group());
}