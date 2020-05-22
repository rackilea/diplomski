String text = "Kane is 12345 feet high";
Pattern p = Pattern.compile("Kane is (\\d+) feet high");
Matcher m = p.matcher(text);
if(m.find()){
String s0 = m.group(0);

}